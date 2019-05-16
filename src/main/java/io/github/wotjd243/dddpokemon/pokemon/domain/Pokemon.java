package io.github.wotjd243.dddpokemon.pokemon.domain;

public class Pokemon {
    private final NationalPokedexNumber number;
    private final String name;
    private final int captureRate;

    public Pokemon(final int number, final String name, final int captureRate) {
        this.number = NationalPokedexNumber.valueOf(number);
        this.name = name;
        this.captureRate = captureRate;
    }

    public boolean isCaught(final int number) {
        return this.captureRate <= number;
    }

    public int getNumber() {
        return number.getNumber();
    }

    public String getName() {
        return name;
    }

    public int getCaptureRate() {
        return captureRate;
    }
}
