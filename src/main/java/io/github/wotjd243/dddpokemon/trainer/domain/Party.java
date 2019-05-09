package io.github.wotjd243.dddpokemon.trainer.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Party {
    @ElementCollection
    private List<PokemonCaught> party;

    public Party(final List<PokemonCaught> party) {
        this.party = new ArrayList<>(party);
    }
}
