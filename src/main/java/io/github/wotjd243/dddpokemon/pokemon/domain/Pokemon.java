package io.github.wotjd243.dddpokemon.pokemon.domain;

public class Pokemon {
    // COMPLETED (1) 원시 데이터 형식 int를 NationalPokedexNumber로 리팩터링
    // COMPLETED (2) 1에서 151 사이의 값을 갖도록 유효성 검사
    private NationalPokedexNumber number;
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
}
