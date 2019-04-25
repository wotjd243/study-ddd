package io.github.wotjd243.dddpokemon.pokemon.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PokemonTest {
    @Test
    public void 포켓몬_생성() {
        // given
        // when
        // then
        new Pokemon(1, "이상해씨", 45);
    }

    @Test
    public void 포획_여부() {
        // given
        final Pokemon pokemon = new Pokemon(1, "이상해씨", 45);

        // when
        final boolean caught = pokemon.isCaught(100);

        // then
        assertThat(caught).isTrue();
    }
}