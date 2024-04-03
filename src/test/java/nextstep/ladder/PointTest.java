package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Point;
import nextstep.ladder.exception.ConsecutivePointException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PointTest {

    @Test
    @DisplayName("[성공] 왼쪽으로 이동할 수 없는, 첫 번째 포인트를 생성한다.")
    void 첫번째_포인트() {
        Point point = Point.first();
        assertThat(point.getDirection()).isIn(Direction.STOP, Direction.RIGHT);
    }

    @Test
    @DisplayName("[성공] 오른쪽으로 이동할 수 없는, 마지막 포인트를 생성한다.")
    void 마지막_포인트() {
        Point point = Point.last(true);
        assertThat(point.getDirection()).isIn(Direction.STOP, Direction.LEFT);
    }

    @Test
    @DisplayName("[성공] 오른쪽으로 이동하는 포인트를 생성한다.")
    void 오른쪽_이동_포인트() {
        Point point = Point.middle(false, true);
        assertThat(point.getDirection()).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("[성공] 왼쪽으로 이동하는 포인트를 생성한다.")
    void 왼쪽_이동_포인트() {
        Point point = Point.middle(true, false);
        assertThat(point.getDirection()).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("[실패] 왼쪽, 오른쪽 모두 이동 가능한 포인트 생성 시 ConsecutivePointException 예외가 발생한다.")
    void 연속_포인트() {
        assertThatExceptionOfType(ConsecutivePointException.class)
                .isThrownBy(() -> Point.middle(true, true))
                .withMessageContaining("왼쪽과 오른쪽으로 모두 이동 가능한 포인트는 생성할 수 없습니다.");
    }
}
