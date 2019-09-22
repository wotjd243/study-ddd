package io.github.wotjd243.dddpokemon.pokemon.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PokemonTest {
    @Test
    void constructor() {
        // given
        // when
        // then
        new Pokemon(1, "이상해씨", 45);
    }

    @DisplayName(value = "계산된 포획률이 포켓몬의 포획률보다 높으면 잡을 수 있다.")
    @Test
    public void isCaught() {
        // given
        final Pokemon pokemon = new Pokemon(1, "이상해씨", 45);

        // when
        final boolean caught = pokemon.isCaught(100);

        // then
        assertThat(caught).isTrue();
    }
}