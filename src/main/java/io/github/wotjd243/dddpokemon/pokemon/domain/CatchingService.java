package io.github.wotjd243.dddpokemon.pokemon.domain;

import io.github.wotjd243.dddpokemon.utils.RandomUtils;

public class CatchingService {
    private static final double POKE_BALL = 1.0;
    private static final int CENT = 100;
    private static final int MINIMUM_CAPTURE_RATE = 255;

    private final Pokemon pokemon;

    public CatchingService(final Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public boolean isCaught() {
        return RandomUtils.nextInt(1, 100) <= calculate();
    }

    private double calculate() {
        return this.pokemon.getCaptureRate() * POKE_BALL * CENT / MINIMUM_CAPTURE_RATE;
    }
}
