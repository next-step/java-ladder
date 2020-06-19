package ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("어느 방향도 아닌 좌표를 지나면 제자리다")
    @Test
    void stay_pass() {
        Point point = Point.first(false);
        Point nextPoint = point.next(false);

        assertThat(nextPoint.pass()).isEqualTo(1);
    }

    @DisplayName("오른쪽 방향의 좌표를 지나면 위치는 +1 된다")
    @Test
    void right_pass() {
        Point point = Point.first(true);
        assertThat(point.pass()).isEqualTo(1);
    }

    @DisplayName("왼쪽 방향의 좌표를 지나면 위치는 -1 된다")
    @Test
    void left_pass() {
        Point point = Point.first(true);
        Point nextPoint = point.next(true);

        assertThat(nextPoint.pass()).isEqualTo(0);
    }
}
