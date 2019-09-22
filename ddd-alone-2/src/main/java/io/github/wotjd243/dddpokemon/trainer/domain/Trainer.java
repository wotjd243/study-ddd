package io.github.wotjd243.dddpokemon.trainer.domain;

public class Trainer {
    private final static int START_LEVEL = 1;
    private final static int MAXIMUM_LEVEL = 30;
    private final static int BONUS_LEVEL = 11;
    private final static int DEFAULT_BONUS = 1;

    private String id;
    private int level;
    private Party party;

    public Trainer(final String id) {
        this.id = id;
        this.level = START_LEVEL;
        this.party = new Party();
    }

    public boolean isNew() {
        return party.isEmpty();
    }

    public boolean registerNewPokemon(final int pokedexNumber, final String nickname) {
        levelUp();
        return party.add(new PokemonCaught(pokedexNumber, nickname));
    }

    private int levelUp() {
        if (this.level < MAXIMUM_LEVEL) {
            this.level++;
        }
        return this.level;
    }

    public int getBonus() {
        if (level >= BONUS_LEVEL) {
            return calculateBonus();
        }
        return DEFAULT_BONUS;
    }

    public int getSizeOfParty() {
        return party.size();
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    private int calculateBonus() {
        return level / 10;
    }
}
