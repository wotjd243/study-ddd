package io.github.wotjd243.dddpokemon.pokemon.domain;

import io.github.wotjd243.dddpokemon.item.domain.Item;
import io.github.wotjd243.dddpokemon.trainer.domain.Trainer;
import io.github.wotjd243.dddpokemon.utils.RandomUtils;

public class CatchingService {
    private static final int CENT = 100;
    private static final int MINIMUM_CAPTURE_RATE = 255;

    private final Pokemon pokemon;
    private final Trainer trainer;
    private final Item item;

    public CatchingService(final Pokemon pokemon, final Trainer trainer, final Item item) {
        this.pokemon = pokemon;
        this.trainer = trainer;
        this.item = item;
    }

    public boolean isCaught() {
        return RandomUtils.nextInt(1, 100) <= calculate();
    }

    private double calculate() {
        final double rate = pokemon.getCaptureRate() * item.getMultiplier() * trainer.getBonus();
        return percentage(rate);
    }

    private double percentage(final double rate) {
        return rate * CENT / MINIMUM_CAPTURE_RATE;
    }
}
