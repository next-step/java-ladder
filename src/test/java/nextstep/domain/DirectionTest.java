package nextstep.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    private static final int LEFT = -1;
    private static final int PASS = 0;
    private static final int RIGHT = 1;

    @Test
    void init() {
        Direction direction = Direction.init(true);
        assertThat(direction.move()).isEqualTo(RIGHT);
    }

    @Test
    void insert_false_when_left_is_true() {
        Direction direction = Direction.init(true).insert(false);
        assertThat(direction.move()).isEqualTo(LEFT);
    }

    @Test
    void insert_true_when_left_is_false() {
        Direction direction = Direction.init(false).insert(true);
        assertThat(direction.move()).isEqualTo(RIGHT);
    }

    @Test
    void insert_false_when_left_is_false() {
        Direction direction = Direction.init(false).insert(false);
        assertThat(direction.move()).isEqualTo(PASS);
    }

    @Test
    void last_when_insert_true() {
        Direction direction = Direction.init(true).insert(true).last();
        assertThat(direction.move()).isEqualTo(PASS);
    }

    @Test
    void last_when_insert_false() {
        Direction direction = Direction.init(true).insert(false).last();
        assertThat(direction.move()).isEqualTo(PASS);
    }

    @Test
    void moveLeft() {
        Direction direction = new Direction(true, false);
        assertThat(direction.move()).isEqualTo(LEFT);
    }

    @Test
    void moveRight() {
        Direction direction = new Direction(false, true);
        assertThat(direction.move()).isEqualTo(RIGHT);
    }

    @Test
    void stop() {
        Direction direction = new Direction(false, false);
        assertThat(direction.move()).isEqualTo(PASS);
    }

}
