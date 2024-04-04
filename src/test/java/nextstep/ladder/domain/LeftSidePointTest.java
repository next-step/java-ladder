package nextstep.ladder.domain;

import nextstep.ladder.data.MoveDirection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeftSidePointTest {

    @DisplayName("현재 위치에서 오른쪽으로 이동한 결과를 반환한다.")
    @Test
    void returnMovedPositionToRight() {
        // given
        Point point = LeftSidePoint.create(MoveDirection.RIGHT);

        // then
        assertThat(point.movePosition(8))
                .isEqualTo(9);
    }

    @DisplayName("현재 위치에서 아래로 이동한 결과를 반환한다.")
    @Test
    void returnMovedPositionToStay() {
        // given
        Point point = LeftSidePoint.create(MoveDirection.STAY);

        // then
        assertThat(point.movePosition(8))
                .isEqualTo(8);
    }
}
