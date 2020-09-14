package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DirectionTest {
    @Test
    void move_left() {
        Direction direction = new Direction(false, true);
        Assertions.assertThat(direction.move()).isEqualTo(1);
    }

    @Test
    void move_current() {
        Direction direction = new Direction(true, false);
        Assertions.assertThat(direction.move()).isEqualTo(-1);
    }

    @Test
    void move_center() {
        Direction direction = new Direction(false, false);
        Assertions.assertThat(direction.move()).isEqualTo(0);
    }

    @Test
    void isLeft() {
        Direction direction = new Direction(true, false);
        Assertions.assertThat(direction.isLeft()).isEqualTo(true);
    }

    @Test
    void isCurrent() {
        Direction direction = new Direction(false, true);
        Assertions.assertThat(direction.isCurrent()).isEqualTo(true);
    }
}