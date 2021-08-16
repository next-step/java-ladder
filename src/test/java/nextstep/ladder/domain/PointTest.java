package nextstep.ladder.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("우회 테스트")
    void exception() {
        Point point = Point.first(true).next(true);
        assertThat(point).isEqualTo(Point.first(true).next(false));
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
