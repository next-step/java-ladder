package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    void left() {
        Direction direction = new Direction(true, false);

        assertThat(direction.move()).isEqualTo(-1);
    }

    @Test
    void right() {
        Direction direction = new Direction(false, true);

        assertThat(direction.move()).isEqualTo(1);
    }

    @Test
    void pass() {
        Direction direction = new Direction(false, false);

        assertThat(direction.move()).isEqualTo(0);
    }
}
