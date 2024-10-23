package ladder2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void next() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(Direction.Left);
    }

    @Test
    void first() {
        Point point = Point.first(true);
        assertThat(point.move()).isEqualTo(Direction.Right);
    }

    @Test
    void invalid() {
        assertThatThrownBy(() -> Point.first(true).next(true))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void left() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(Direction.Left);
    }

    @Test
    void right() {
        Point point = Point.first(true);
        assertThat(point.move()).isEqualTo(Direction.Right);
    }

    @Test
    void south() {
        Point point = Point.first(false);
        assertThat(point.move()).isEqualTo(Direction.South);
    }
}
