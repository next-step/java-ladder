package nextstep.laddergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomStrategyTest {

    @Test
    void isMovableTest() {

        RandomStrategy randomStrategy = new RandomStrategy();
        Assertions.assertThat(randomStrategy.isMovable()).isIn(Boolean.TRUE, Boolean.FALSE);

    }
}