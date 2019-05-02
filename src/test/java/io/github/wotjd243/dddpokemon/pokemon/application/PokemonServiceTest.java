package io.github.wotjd243.dddpokemon.pokemon.application;

import io.github.wotjd243.dddpokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.dddpokemon.pokemon.domain.PokemonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class PokemonServiceTest {
    @Mock
    private PokemonRepository pokemonRepository;

    @InjectMocks
    private PokemonService pokemonService;

    @Test
    public void name() {
        // given
        given(pokemonRepository.findById(any()))
                .willReturn(
                        Optional.of(
                                new Pokemon(1, "이상해씨", 255)
                        )
                )
        ;

        // when
        final boolean caught = pokemonService.catchPokemon(1);

        // then
        assertThat(caught).isTrue();
    }
}