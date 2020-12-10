package ladder.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DirectionTest {
    @Test
    void move_left() {
        Direction direction = Direction.of(true, false);
        Assertions.assertThat(direction.move()).isEqualTo(-1);
    }

    @Test
    void move_right() {
        Direction direction = Direction.of(false, true);
        Assertions.assertThat(direction.move()).isEqualTo(1);
    }

    @Test
    void move_center() {
        Direction direction = Direction.of(false, false);
        Assertions.assertThat(direction.move()).isEqualTo(0);
    }

    @Test
    void isLeft() {
        Direction direction = Direction.of(true, false);
        Assertions.assertThat(direction.isLeft()).isEqualTo(true);
    }

    @Test
    void isRight() {
        Direction direction = Direction.of(false, true);
        Assertions.assertThat(direction.isRight()).isEqualTo(true);
    }

    @Test
    void testEquals() {
        Assertions.assertThat(Direction.of(false, true))
                .isEqualTo(Direction.of(false, true));
    }

    @Test
    void testHashCode() {
        Assertions.assertThat(Direction.of(false, true).hashCode())
                .isEqualTo(Direction.of(false, true).hashCode());
    }
}
