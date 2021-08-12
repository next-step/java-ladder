package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PositionTest {
    @Test
    void right() {
        Position position = Position.of(0, Direction.RIGHT);
        assertThat(position.move()).isEqualTo(1);
    }

    @Test
    void left() {
        Position position = Position.of(1, Direction.LEFT);
        assertThat(position.move()).isEqualTo(0);
    }

    @Test
    void down() {
        Position position2 = Position.of(0, Direction.DOWN);
        assertThat(position2.move()).isEqualTo(0);
    }
}