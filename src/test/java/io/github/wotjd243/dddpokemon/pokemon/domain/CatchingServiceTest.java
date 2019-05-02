package io.github.wotjd243.dddpokemon.pokemon.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CatchingServiceTest {
    private static final Pokemon TEST_POKEMON_EASY_TO_CATCH = new Pokemon(10, "캐터피", 255);
    private static final Pokemon TEST_POKEMON_HARD_TO_CATCH = new Pokemon(150, "뮤츠", 0);

    @Test
    public void 무조건_잡히는_경우() {
        // given
        final CatchingService catchingService = new CatchingService(TEST_POKEMON_EASY_TO_CATCH);

        // when
        final boolean caught = catchingService.isCaught();

        // then
        assertThat(caught).isTrue();
    }

    @Test
    public void 무조건_잡히지_않는_경우() {
        // given
        final CatchingService catchingService = new CatchingService(TEST_POKEMON_HARD_TO_CATCH);

        // when
        final boolean caught = catchingService.isCaught();

        // then
        assertThat(caught).isFalse();
    }
}