package io.github.wotjd243.dddpokemon.pokemon.domain;

public class Pokemon {
    private final NationalPokedexNumber number;
    private final String name;
    private CaptureRate captureRate;

    public Pokemon(final int number, final String name, final int captureRate) {
        this.number = NationalPokedexNumber.valueOf(number);
        this.name = name;
        this.captureRate = CaptureRate.valueOf(captureRate);
    }

    public boolean isCaught(final int number) {
        return this.captureRate.isCaught(number);
    }

    public void changeCaptureRate(final int captureRate) {
        this.captureRate = this.captureRate.change(captureRate);
    }

    public int getNumber() {
        return number.toInt();
    }

    public String getName() {
        return name;
    }

    public int getCaptureRate() {
        return captureRate.toInt();
    }
}
