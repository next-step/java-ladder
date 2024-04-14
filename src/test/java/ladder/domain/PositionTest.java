package ladder.domain;

import ladder.domain.participants.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void move_left_side() {
        int initPosition = 1;
        Position position = new Position(initPosition);
        Position moved = new Position(initPosition - 1);

        assertThat(position.moveLeft()).isEqualTo(moved);
    }

    @Test
    void move_right_side() {
        int initPosition = 1;
        Position position = new Position(initPosition);
        Position moved = new Position(initPosition + 1);

        assertThat(position.moveRight()).isEqualTo(moved);
    }

    @Test
    void bypass() {
        int initPosition = 1;
        Position position = new Position(initPosition);

        assertThat(position.byPass()).isEqualTo(position);
    }
}