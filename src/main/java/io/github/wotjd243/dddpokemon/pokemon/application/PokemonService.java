package io.github.wotjd243.dddpokemon.pokemon.application;

import io.github.wotjd243.dddpokemon.item.application.ItemService;
import io.github.wotjd243.dddpokemon.item.domain.Item;
import io.github.wotjd243.dddpokemon.pokemon.domain.CatchingService;
import io.github.wotjd243.dddpokemon.pokemon.domain.NationalPokedexNumber;
import io.github.wotjd243.dddpokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.dddpokemon.pokemon.domain.PokemonRepository;
import io.github.wotjd243.dddpokemon.trainer.application.TrainerService;
import io.github.wotjd243.dddpokemon.trainer.domain.Trainer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PokemonService {
    private PokemonRepository pokemonRepository;
    // COMPLETED (5) 트레이너 서비스를 필드로 추가
    // COMPLETED (6) 아이템 서비스를 필드로 추가
    private TrainerService trainerService;
    private ItemService itemService;

    // COMPLETED (7) 트레이너 서비스와 아이템 서비스를 생성자를 통해 주입 받도록 변경
    public PokemonService(final PokemonRepository pokemonRepository, final TrainerService trainerService, final ItemService itemService) {
        this.pokemonRepository = pokemonRepository;
        this.trainerService = trainerService;
        this.itemService = itemService;
    }

    // COMPLETED (8) 포켓몬 번호 외에 트레이너 아이디와 아이템 아이디를 인자로 받도록 수정
    @Transactional
    public boolean catchPokemon(final int number, final String trainerId, final long itemId) {
        final Pokemon pokemon = getPokemon(number);
        // COMPLETED (9) 트레이너 서비스를 통해 트레이너 AGGREGATE 조회
        // COMPLETED (10) 아이템 서비스를 통해 아이템 AGGREGATE 조회
        // COMPLETED (11) CatchingService 수정
        final Trainer trainer = trainerService.getTrainer(trainerId);
        final Item item = itemService.getItem(itemId);
        final CatchingService catchingService = new CatchingService(pokemon, trainer, item);
        // COMPLETED (12) 잡는 것에 성공하면 트레이너 서비스의 registerNewPokemon()를 호출하도록 변경
        final boolean caught = catchingService.isCaught();
        if (caught) {
            trainerService.registerNewPokemon(trainerId, pokemon.getNumber(), pokemon.getName());
        }
        return caught;
    }

    public Pokemon getPokemon(final int number) {
        return pokemonRepository.findById(NationalPokedexNumber.valueOf(number))
                .orElseThrow(IllegalArgumentException::new)
                ;
    }
}
