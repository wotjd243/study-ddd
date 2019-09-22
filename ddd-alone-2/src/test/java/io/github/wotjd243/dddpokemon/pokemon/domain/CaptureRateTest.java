package io.github.wotjd243.dddpokemon.pokemon.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CaptureRateTest {
    @ParameterizedTest
    @ValueSource(ints = {3, 255})
    void valueOf(final int captureRate) {
        // given
        // when
        // then
        CaptureRate.valueOf(captureRate);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 256})
    void valueOf_ThrowIllegalArgumentException(final int captureRate) {
        // given
        // when
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CaptureRate.valueOf(captureRate));
    }
}