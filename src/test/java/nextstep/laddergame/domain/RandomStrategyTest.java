package nextstep.laddergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomStrategyTest {

    @Test
    void isMovableTest() {
        Assertions.assertThat(RandomStrategy.isMovable()).isIn(Boolean.TRUE, Boolean.FALSE);
    }
}