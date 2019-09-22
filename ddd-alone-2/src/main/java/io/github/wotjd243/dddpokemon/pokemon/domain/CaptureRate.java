package io.github.wotjd243.dddpokemon.pokemon.domain;

import java.util.Objects;

public class CaptureRate {
    private static final int MINIMUM_NUMBER = 3;
    private static final int MAXIMUM_NUMBER = 255;

    private final int captureRate;

    private CaptureRate(final int captureRate) {
        validate(captureRate);
        this.captureRate = captureRate;
    }

    static CaptureRate valueOf(final int captureRate) {
        return new CaptureRate(captureRate);
    }

    boolean isCaught(final int captureRate) {
        return this.captureRate < captureRate;
    }

    CaptureRate change(final int captureRate) {
        return new CaptureRate(captureRate);
    }

    int toInt() {
        return captureRate;
    }

    private void validate(final int captureRate) {
        if (captureRate < MINIMUM_NUMBER || captureRate > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CaptureRate that = (CaptureRate) o;
        return captureRate == that.captureRate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(captureRate);
    }
}
