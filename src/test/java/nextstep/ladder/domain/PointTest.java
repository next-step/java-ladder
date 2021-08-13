package nextstep.ladder.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    void first() {
        Point point = Point.first(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void last() {
        Point point = Point.first(true).next(false).last();
        assertThat(point.move()).isEqualTo(Direction.PASS);
    }

    @Test
    void left() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void exception() {
        assertThatThrownBy(() -> {
            Point.first(true).next(true);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void right() {
        Point point = Point.first(false).next(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void pass() {
        Point point = Point.first(false).next(false);
        assertThat(point.move()).isEqualTo(Direction.PASS);
    }


}
