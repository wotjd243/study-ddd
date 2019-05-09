package io.github.wotjd243.dddpokemon.trainer.domain;

import java.util.Optional;

public interface TrainerRepository {
    void save(Trainer trainer);
    Optional<Trainer> findById(String id);
}
