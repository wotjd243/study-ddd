package io.github.wotjd243.dddpokemon.trainer.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trainer {
    @Id
    private String id;
    private int level;

    @Embedded
    private Party party;

    private Trainer() {
    }

    public Trainer(final String id, final int level) {
        this.id = id;
        this.level = level;
    }
}
