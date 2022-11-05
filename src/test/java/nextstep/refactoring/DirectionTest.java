package nextstep.refactoring;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {
    @Test
    void right() {
        Direction right = Direction.RIGHT;
        assertThat(right.moveDirection(0)).isEqualTo(1);
    }

    @Test
    void left() {
        Direction right = Direction.LEFT;
        assertThat(right.moveDirection(1)).isEqualTo(0);
    }

    @Test
    void PASS() {
        Direction right = Direction.PASS;
        assertThat(right.moveDirection(2)).isEqualTo(2);
    }
}