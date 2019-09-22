package io.github.wotjd243.dddpokemon.trainer.domain;

public class PokemonCaught {
    private final int pokedexNumber;
    private String nickname;

    public PokemonCaught(final int pokedexNumber, final String nickname) {
        this.pokedexNumber = pokedexNumber;
        this.nickname = nickname;
    }
}
