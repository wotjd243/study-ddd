package io.github.wotjd243.dddpokemon.pokemon.domain;

import io.github.wotjd243.dddpokemon.utils.RandomUtils;

public class CatchingService {
    // TODO (4) 사용하지 않는 상수 제거
    private static final double POKE_BALL = 1.0;
    private static final int CENT = 100;
    private static final int MINIMUM_CAPTURE_RATE = 255;

    private final Pokemon pokemon;
    // TODO (1) Trainer 와 Item 을 필드로 추가

    // TODO (2) CatchingService 생성자의 인자로 Pokemon 외에도 Trainer 와 Item 를 받도록 수정
    public CatchingService(final Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public boolean isCaught() {
        return RandomUtils.nextInt(1, 100) <= calculate();
    }

    private double calculate() {
        // TODO (3) (포켓몬의 포획률 * 몬스터볼 보정 승수 * (레벨 11 이상의 트레이너 레벨 / 10)) * 100 / 255
        return this.pokemon.getCaptureRate() * POKE_BALL * CENT / MINIMUM_CAPTURE_RATE;
    }
}
