package io.github.wotjd243.dddpokemon.trainer.domain;

import javax.persistence.Embeddable;

@Embeddable
public class PokemonCaught {
    private int pokedexNumber;
    private String nickname;

    private PokemonCaught() {
    }

    public PokemonCaught(final int pokedexNumber, final String nickname) {
        this.pokedexNumber = pokedexNumber;
        this.nickname = nickname;
    }
}
