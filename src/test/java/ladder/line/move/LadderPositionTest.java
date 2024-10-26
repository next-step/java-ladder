package ladder.line.move;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderPositionTest {

    @DisplayName("현재 위치에서 오른쪽으로 이동하면 현재 위치가 1 증가한다.")
    @Test
    void right() {
        Point right = Point.first(true);

        LadderPosition ladderPosition = new LadderPosition(new Position(1), right);

        assertThat(ladderPosition.move()).isEqualTo(new Position(2));
    }

    @DisplayName("현재 위치에서 왼쪽으로 이동하면 현재 위치가 1 감소한다.")
    @Test
    void left() {
        Point left = Point.first(true).next(false);

        LadderPosition ladderPosition = new LadderPosition(new Position(1), left);

        assertThat(ladderPosition.move()).isEqualTo(new Position(0));
    }

    @DisplayName("현재 위치에서 이동할 수 없는 경우 현재 위치는 변하지 않는다.")
    @Test
    void pass() {
        Point pass = Point.first(false).next(false);

        LadderPosition ladderPosition = new LadderPosition(new Position(1), pass);

        assertThat(ladderPosition.move()).isEqualTo(new Position(1));
    }
}
