package io.github.wotjd243.dddpokemon.pokemon.application;

import io.github.wotjd243.dddpokemon.pokemon.domain.CatchingService;
import io.github.wotjd243.dddpokemon.pokemon.domain.NationalPokedexNumber;
import io.github.wotjd243.dddpokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.dddpokemon.pokemon.domain.PokemonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PokemonService {
    private PokemonRepository pokemonRepository;
    // TODO (5) 트레이너 서비스를 필드로 추가
    // TODO (6) 아이템 서비스를 필드로 추가

    // TODO (7) 트레이너 서비스와 아이템 서비스를 생성자를 통해 주입 받도록 변경
    public PokemonService(final PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public boolean catchPokemon(final int number) {
    // TODO (8) 포켓몬 번호 외에 트레이너 아이디와 아이템 아이디를 인자로 받도록 수정
    @Transactional
        final Pokemon pokemon = getPokemon(number);
        // TODO (9) 트레이너 서비스를 통해 트레이너 AGGREGATE 조회
        // TODO (10) 아이템 서비스를 통해 아이템 AGGREGATE 조회
        // TODO (11) CatchingService 수정
        final CatchingService catchingService = new CatchingService(pokemon);
        // TODO (12) 잡는 것에 성공하면 트레이너 서비스의 registerNewPokemon()를 호출하도록 변경
        return catchingService.isCaught();
    }

    public Pokemon getPokemon(final int number) {
        return pokemonRepository.findById(NationalPokedexNumber.valueOf(number))
                .orElseThrow(IllegalArgumentException::new)
                ;
    }
}
