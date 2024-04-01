package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void move_when_can_move() {
        Position position = new Position(1);
        assertThat(position.move(num -> true)).isEqualTo(new Position(2));
        assertThat(position.move(num -> false)).isEqualTo(new Position(1));
    }
}