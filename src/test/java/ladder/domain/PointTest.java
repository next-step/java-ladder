package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("LEFT 면 포지션이 감소, DOWN 이면 그대로, RIGHT 면 증가해야한다.")
    void move() {
        int index = 5;
        Assertions.assertAll(
                () -> assertThat(new Point(index, Direction.LEFT).move())
                        .isEqualTo(4),
                () -> assertThat(new Point(index, Direction.DOWN).move())
                        .isEqualTo(5),
                () -> assertThat(new Point(index, Direction.RIGHT).move())
                        .isEqualTo(6)
        );
    }
}
