package step3.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    void right() {
        Point point = Point.first(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void left() {
        Point point = Point.first(true).next();
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void pass() {
        Point point = Point.first(true).next().last();
        assertThat(point.move()).isEqualTo(Direction.SKIP);
    }
}