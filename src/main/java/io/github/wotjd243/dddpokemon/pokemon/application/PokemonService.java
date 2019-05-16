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
    private TrainerService trainerService;
    private ItemService itemService;
    // TODO (1) ApplicationEventPublisher 를 필드로 추가

    // TODO (2) 생성자를 통해 주입 받도록 변경
    public PokemonService(final PokemonRepository pokemonRepository, final TrainerService trainerService, final ItemService itemService) {
        this.pokemonRepository = pokemonRepository;
        this.trainerService = trainerService;
        this.itemService = itemService;
    }

    @Transactional
    public boolean catchPokemon(final int number, final String trainerId, final long itemId) {
        final Pokemon pokemon = getPokemon(number);
        final Trainer trainer = trainerService.getTrainer(trainerId);
        final Item item = itemService.getItem(itemId);
        final CatchingService catchingService = new CatchingService(pokemon, trainer, item);
        final boolean caught = catchingService.isCaught();
        // TODO (3) 트레이너 아이디, 포켓몬 번호, 포켓몬 이름, 잡는 것 성공 여부를 담을 이벤트 만들기
        // TODO (4) 잡혔을 때 publishEvent()
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
