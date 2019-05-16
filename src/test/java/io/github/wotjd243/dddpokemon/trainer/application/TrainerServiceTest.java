package io.github.wotjd243.dddpokemon.trainer.application;

import io.github.wotjd243.dddpokemon.trainer.domain.Trainer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrainerServiceTest {
    @Autowired
    private TrainerService trainerService;

    @Before
    public void setUp() {
        final Trainer trainer = trainerService.join("wotjd243");
        assertThat(trainer.getSizeOfParty()).isEqualTo(0);
    }

    @Test
    public void 신규_포켓몬_등록() {
        final Trainer trainer = trainerService.registerNewPokemon("wotjd243", 1, "이상해씨");
        assertThat(trainer.getSizeOfParty()).isEqualTo(1);
    }
}