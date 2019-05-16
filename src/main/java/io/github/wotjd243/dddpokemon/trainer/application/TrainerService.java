package io.github.wotjd243.dddpokemon.trainer.application;

import io.github.wotjd243.dddpokemon.trainer.domain.Trainer;
import io.github.wotjd243.dddpokemon.trainer.domain.TrainerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TrainerService {
    private TrainerRepository trainerRepository;

    public TrainerService(final TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Transactional
    public Trainer join(final String id) {
        return trainerRepository.save(new Trainer(id));
    }

    // TODO (5) @EventListener 추가
    // TODO (6) 이벤트를 인자로 수정
    // TODO (7) 잡는 것에 성공한 경우 핸들링하도록 수정
    @Transactional
    public Trainer registerNewPokemon(final String id, final int pokedexNumber, final String nickname) {
        final Trainer trainer = getTrainer(id);
        trainer.registerNewPokemon(pokedexNumber, nickname);
        return trainer;
    }

    public Trainer getTrainer(final String id) {
        return trainerRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new)
                ;
    }
}
