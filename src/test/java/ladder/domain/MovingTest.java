package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingTest {

    @Test
    void pass() {
        Moving moving = new Moving(1, Point.first(false));
        assertThat(moving.move()).isEqualTo(1);
    }

    @Test
    void left() {
        Moving moving = new Moving(1, Point.first(true).next(false));
        assertThat(moving.move()).isEqualTo(0);
    }

    @Test
    void right() {
        Moving moving = new Moving(1, Point.first(true));
        assertThat(moving.move()).isEqualTo(2);
    }
}
