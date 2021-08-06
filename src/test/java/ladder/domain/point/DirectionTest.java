package ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.point.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {
    @Test
    @DisplayName("emptyTest")
    void emptyTest() {
        assertThat(EMPTY.isEmpty())
                .isTrue();
    }

    @Test
    @DisplayName("leftTest")
    void leftTest() {
        assertThat(LEFT.isLeft())
                .isTrue();
    }

    @Test
    @DisplayName("rightTest")
    void rightTest() {
        assertThat(RIGHT.isRight())
                .isTrue();
    }
}
