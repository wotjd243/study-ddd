package io.github.wotjd243.dddpokemon.trainer.domain;

import javax.persistence.Embeddable;

@Embeddable
public class PokemonCaught {
    private final int number;
    private final String nickname;

    public PokemonCaught(final int number, final String nickname) {
        this.number = number;
        this.nickname = nickname;
    }
}
