package io.github.wotjd243.dddpokemon.trainer.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class TrainerTest {
    @Test
    void constructor() {
        // given
        // when
        final Trainer trainer = new Trainer("jason");

        // then
        assertThat(trainer.getId()).isEqualTo("jason");
        assertThat(trainer.getLevel()).isOne();
    }

    @Test
    void isNew() {
        // given
        final Trainer trainer = new Trainer("jason");

        // when
        // then
        assertThat(trainer.isNew()).isTrue();
    }

    @Test
    void registerNewPokemon() {
        // given
        final Trainer trainer = new Trainer("jason");

        // when
        trainer.registerNewPokemon(1, "이상해씨");

        // then
        assertThat(trainer.isNew()).isFalse();
        assertThat(trainer.getLevel()).isEqualTo(2);
    }

    @Test
    void registerNewPokemon_ThrowIllegalArgumentException() {
        // given
        final Trainer trainer = new Trainer("jason");

        // when
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    trainer.registerNewPokemon(1, "이상해씨");
                    trainer.registerNewPokemon(2, "이상해풀");
                    trainer.registerNewPokemon(3, "이상해꽃");
                    trainer.registerNewPokemon(4, "파이리");
                    trainer.registerNewPokemon(5, "리자드");
                    trainer.registerNewPokemon(6, "리자몽");
                    trainer.registerNewPokemon(7, "꼬부기");
                })
        ;
    }
}