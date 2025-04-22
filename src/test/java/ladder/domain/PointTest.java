package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {
    @Test
    void first() {
        Point point = Point.first(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void move_right() {
        Point point = Point.first(false).next(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void move_left() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void move_straight() {
        Point point = Point.first(false).next(false);
        assertThat(point.move()).isEqualTo(Direction.SOUTH);
    }

    @Test
    void invalid_input() {
        assertThatThrownBy(() -> Point.first(true).next(true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void last() {
        Point point = Point.first(false).next(false).last();
        assertThat(point.move()).isEqualTo(Direction.SOUTH);
    }
}
