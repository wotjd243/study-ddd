package io.github.wotjd243.dddpokemon.trainer.infra;

import io.github.wotjd243.dddpokemon.trainer.domain.Trainer;
import io.github.wotjd243.dddpokemon.trainer.domain.TrainerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class JpaTrainerRepository implements TrainerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Trainer save(final Trainer trainer) {
        this.entityManager.persist(trainer);
        return trainer;
    }

    @Override
    public Optional<Trainer> findById(final String id) {
        final Trainer trainer = this.entityManager.find(Trainer.class, id);
        return Optional.ofNullable(trainer);
    }
}
