package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class PointTest {

    @Test
    void hasNotLineBefore() {
        Point point = Point.init(false).next(true);
        assertThat(point.hasLineBefore()).isEqualTo(false);
    }

    @Test
    void hasLineBefore() {
        Point point = Point.init(true).next(false);
        assertThat(point.hasLineBefore()).isEqualTo(true);
    }
    @Test
    void right() {
        Point point = Point.init(false).next(true);
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    void pass() {
        Point point = Point.init(false).next(false);
        assertThat(point.move()).isEqualTo(0);
    }

    @Test
    void left() {
        Point point = Point.init(true).next(false);
        assertThat(point.move()).isEqualTo(-1);
    }

    @Test
    void end() {
        Point point = Point.init(false).end();
        assertThat(point.move()).isEqualTo(0);
    }
}