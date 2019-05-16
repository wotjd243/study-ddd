package io.github.wotjd243.dddpokemon.item.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double multiplier;

    private Item() {
    }

    public double getMultiplier() {
        return multiplier;
    }
}
