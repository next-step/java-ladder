package ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderPointTest {
    @DisplayName("오른쪽 Point 요청시 index가 + 1 되어야 한다.")
    @Test
    void moveRightTest() {
        LadderPoint point = new LadderPoint(0, Direction.RIGHT);
        assertThat(point.move())
                .isEqualTo(1);
    }

    @DisplayName("왼쪽 Point 요청시 index가 - 1 되어야 한다.")
    @Test
    void moveLeftTest() {
        LadderPoint point = new LadderPoint(1, Direction.LEFT);
        assertThat(point.move())
                .isZero();
    }
}