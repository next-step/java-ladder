package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    @DisplayName("[성공] 오른쪽으로 이동하는 포인트를 생성한다.")
    void 오른쪽_이동_포인트() {
        Point point = new Point(false, true);
        Assertions.assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("[성공] 왼쪽으로 이동하는 포인트를 생성한다.")
    void 왼쪽_이동_포인트() {
        Point point = new Point(true, false);
        Assertions.assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

}
