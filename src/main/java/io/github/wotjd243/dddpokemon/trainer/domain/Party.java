package io.github.wotjd243.dddpokemon.trainer.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Party {
    private static int MAXIMUM_NUMBER_TO_CARRY = 6;

    @ElementCollection
    private List<PokemonCaught> party;

    public Party() {
        this.party = new ArrayList<>();
    }

    public boolean add(final PokemonCaught pokemonCaught) {
        checkCarryIt();
        return this.party.add(pokemonCaught);
    }

    public int size() {
        return this.party.size();
    }

    private void checkCarryIt() {
        if (size() >= MAXIMUM_NUMBER_TO_CARRY) {
            throw new IllegalArgumentException();
        }
    }
}
