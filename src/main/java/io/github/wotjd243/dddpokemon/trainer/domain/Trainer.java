package io.github.wotjd243.dddpokemon.trainer.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trainer {
    private final static int START_LEVEL = 1;
    private final static int MAXIMUM_LEVEL = 30;

    @Id
    private String id;
    private int level;

    @Embedded
    private Party party;

    private Trainer() {
    }

    public Trainer(final String id) {
        this.id = id;
        this.level = START_LEVEL;
        this.party = new Party();
    }

    public boolean isNew() {
        return this.party.size() == 0;
    }

    public boolean registerNewPokemon(final int pokedexNumber, final String nickname) {
        final boolean success = this.party.add(new PokemonCaught(pokedexNumber, nickname));
        levelUp();
        return success;
    }

    public int levelUp() {
        if (this.level < MAXIMUM_LEVEL) {
            this.level++;
        }
        return this.level;
    }

    public int getSizeOfParty() {
        return this.party.size();
    }
}
