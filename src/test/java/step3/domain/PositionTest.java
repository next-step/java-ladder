package step3.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    @Test
    void right() {
        Point point = Point.first(true);
        Position position = new Position(1, point);
        assertThat(position.move()).isEqualTo(2);
    }

    @Test
    void left() {
        Point point = Point.first(true).next();
        Position position = new Position(1, point);
        assertThat(position.move()).isEqualTo(0);
    }

    @Test
    void pass() {
        Point point = Point.first(true).next().last();
        Position position = new Position(1, point);
        assertThat(position.move()).isEqualTo(1);
    }

}