package io.github.wotjd243.dddpokemon.pokemon.application;

import io.github.wotjd243.dddpokemon.pokemon.domain.CatchingService;
import io.github.wotjd243.dddpokemon.pokemon.domain.NationalPokedexNumber;
import io.github.wotjd243.dddpokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.dddpokemon.pokemon.domain.PokemonRepository;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
    // TODO (1) PokemonServiceTest 만들기
    // TODO (2) @Mock을 사용하여 PokemonRepository Mock 만들기
    // TODO (3) @@InjectMocks을 사용하여 PokemonService에 Mock 주입
    // TODO (4) PokemonServiceTest 단위 테스트
    private PokemonRepository pokemonRepository;

    public PokemonService(final PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public boolean catchPokemon(final int number) {
        final Pokemon pokemon = getPokemon(number);
        final CatchingService catchingService = new CatchingService(pokemon);
        return catchingService.isCaught();
    }

    private Pokemon getPokemon(final int number) {
        return pokemonRepository.findById(NationalPokedexNumber.valueOf(number))
                .orElseThrow(IllegalArgumentException::new)
                ;
    }
}
