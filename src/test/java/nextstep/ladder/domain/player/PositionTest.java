package nextstep.ladder.domain.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Position은 참가자가 현재 어떤 위치에 있는지 표현한다. 사다리의 가장 왼쪽 위치는 0이다.
 */
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
