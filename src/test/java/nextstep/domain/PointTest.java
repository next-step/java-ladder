package nextstep.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    private static final int LEFT = -1;
    private static final int PASS = 0;
    private static final int RIGHT = 1;

    @Test
    void init() {
        Point point = Point.init(true);
        assertThat(point.move()).isEqualTo(RIGHT);
    }

    @Test
    void insert_false_when_left_is_true() {
        Point point = Point.init(true).insert(false);
        assertThat(point.move()).isEqualTo(LEFT);
    }

    @Test
    void insert_true_when_left_is_false() {
        Point point = Point.init(false).insert(true);
        assertThat(point.move()).isEqualTo(RIGHT);
    }

    @Test
    void insert_false_when_left_is_false() {
        Point point = Point.init(false).insert(false);
        assertThat(point.move()).isEqualTo(PASS);
    }

    @Test
    void last_when_insert_true() {
        Point point = Point.init(true).insert(true).last();
        assertThat(point.move()).isEqualTo(PASS);
    }

    @Test
    void last_when_insert_false() {
        Point point = Point.init(true).insert(false).last();
        assertThat(point.move()).isEqualTo(PASS);
    }

    @Test
    void moveLeft() {
        Point point = new Point(true, false);
        assertThat(point.move()).isEqualTo(LEFT);
    }

    @Test
    void moveRight() {
        Point point = new Point(false, true);
        assertThat(point.move()).isEqualTo(RIGHT);
    }

    @Test
    void stop() {
        Point point = new Point(false, false);
        assertThat(point.move()).isEqualTo(PASS);
    }

}
