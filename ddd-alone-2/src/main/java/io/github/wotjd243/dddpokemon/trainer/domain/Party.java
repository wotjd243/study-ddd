package io.github.wotjd243.dddpokemon.trainer.domain;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private static int MAXIMUM_NUMBER_TO_CARRY = 6;

    private List<PokemonCaught> party = new ArrayList<>();

    boolean add(final PokemonCaught pokemonCaught) {
        validateCarryIt();
        return party.add(pokemonCaught);
    }

    boolean isEmpty() {
        return party.isEmpty();
    }

    int size() {
        return party.size();
    }

    private void validateCarryIt() {
        if (party.size() >= MAXIMUM_NUMBER_TO_CARRY) {
            throw new IllegalArgumentException();
        }
    }
}
