package ladder;

import ladder.domain.Point;
import ladder.domain.Way;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    @DisplayName("Point 초기화시 방향은 왼쪽일 수 없다")
    void initPoint() {
        Point point = new Point();
        Assertions.assertThat(point.getWay()).isNotEqualTo(Way.LEFT);
    }

    @Test
    @DisplayName("왼쪽 포인트가 오른쪽 방향일시 왼쪽 방향으로 초기화된다")
    void leftPointIsRightWay() {
        Point leftPoint = new Point(Way.RIGHT);
        Point point = new Point(leftPoint, true);
        Assertions.assertThat(point.getWay()).isEqualTo(Way.LEFT);
    }

    @Test
    @DisplayName("왼쪽 포인트가 아래 방향일시 왼쪽 방향으로 초기화되지 않는다")
    void leftPointIsDownWay() {
        Point leftPoint = new Point(Way.DOWN);
        Point point = new Point(leftPoint, true);
        Assertions.assertThat(point.getWay()).isNotEqualTo(Way.LEFT);
    }

    @Test
    @DisplayName("오른쪽 포인트가 존재하지 않을시 오른쪽방향으로 초기화 되지 않는다")
    void noRightPoint() {
        Point leftPoint = new Point(Way.DOWN);
        Point point = new Point(leftPoint, false);
        Assertions.assertThat(point.getWay()).isNotEqualTo(Way.RIGHT);
    }
}
