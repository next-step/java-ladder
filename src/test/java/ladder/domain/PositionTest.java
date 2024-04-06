package ladder.domain;

import ladder.domain.participants.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void move_when_can_move() {
        Position position = new Position(1);

        assertThat(position.move(num -> true)).isEqualTo(new Position(2));
        assertThat(position.move(num -> false)).isEqualTo(new Position(1));
    }

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
}