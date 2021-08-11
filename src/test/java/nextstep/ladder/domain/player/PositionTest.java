package nextstep.ladder.domain.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PositionTest {
    @Test
    void moveLeft() {
        Position position = Position.from(5);
        Position left = position.moveLeft();
        Assertions.assertThat(left.currentPosition()).isEqualTo(5 - 1);
    }

    @Test
    void moveRight() {
        Position position = Position.from(5);
        Position right = position.moveRight();
        Assertions.assertThat(right.currentPosition()).isEqualTo(5 + 1);
    }
}
