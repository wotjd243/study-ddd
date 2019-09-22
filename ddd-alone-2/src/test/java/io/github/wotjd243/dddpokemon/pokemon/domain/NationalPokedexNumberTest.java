package io.github.wotjd243.dddpokemon.pokemon.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NationalPokedexNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 151})
    void valueOf(final int number) {
        // given
        // when
        // then
        NationalPokedexNumber.valueOf(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 152})
    void valueOf_ThrowIllegalArgumentException(final int number) {
        // given
        // when
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> NationalPokedexNumber.valueOf(number));
    }
}