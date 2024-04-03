package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("[성공] 오른쪽으로만 이동할 수 있는, 첫 번째 포인트를 생성한다.")
    void 첫번째_포인트() {
        Point point = Point.first();
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("[성공] 왼쪽으로만 이동할 수 있는, 마지막 포인트를 생성한다.")
    void 마지막_포인트() {
        Point point = Point.last();
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("[성공] 오른쪽으로 이동하는 포인트를 생성한다.")
    void 오른쪽_이동_포인트() {
        Point point = new Point(false, true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("[성공] 왼쪽으로 이동하는 포인트를 생성한다.")
    void 왼쪽_이동_포인트() {
        Point point = new Point(true, false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

}
