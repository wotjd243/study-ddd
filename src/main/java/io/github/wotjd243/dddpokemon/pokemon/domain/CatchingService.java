package io.github.wotjd243.dddpokemon.pokemon.domain;

import io.github.wotjd243.dddpokemon.item.domain.Item;
import io.github.wotjd243.dddpokemon.trainer.domain.Trainer;
import io.github.wotjd243.dddpokemon.utils.RandomUtils;

public class CatchingService {
    // COMPLETED (4) 사용하지 않는 상수 제거
    private static final int CENT = 100;
    private static final int MINIMUM_CAPTURE_RATE = 255;

    private final Pokemon pokemon;
    // COMPLETED (1) Trainer 와 Item 을 필드로 추가
    private final Trainer trainer;
    private final Item item;

    // COMPLETED (2) CatchingService 생성자의 인자로 Pokemon 외에도 Trainer 와 Item 를 받도록 수정
    public CatchingService(final Pokemon pokemon, final Trainer trainer, final Item item) {
        this.pokemon = pokemon;
        this.trainer = trainer;
        this.item = item;
    }

    public boolean isCaught() {
        return RandomUtils.nextInt(1, 100) <= calculate();
    }

    private double calculate() {
        // COMPLETED (3) (포켓몬의 포획률 * 몬스터볼 보정 승수 * (레벨 11 이상의 트레이너 레벨 / 10)) * 100 / 255
        final double rate = pokemon.getCaptureRate() * item.getMultiplier() * trainer.getBonus();
        return percentage(rate);
    }

    private double percentage(final double rate) {
        return rate * CENT / MINIMUM_CAPTURE_RATE;
    }
}
