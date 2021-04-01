package ladder;

import ladder.domain.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    @DisplayName("현재 지점과 왼쪽 모두 선이 없으면 제자리에 있는다.")
    void stay() {
        Point point = new Point();
        Assertions.assertThat(point.direction()).isEqualTo(0);
    }

    @Test
    @DisplayName("현재 지점에 선이 있으면 우측으로 이동한다.")
    void right() {
        Point point = new Point(true);
        Assertions.assertThat(point.direction()).isEqualTo(1);
    }

    @Test
    @DisplayName("좌측에 선이 있으면 좌측으로 이동한다.")
    void left() {
        Point point = new Point(true, false);
        Assertions.assertThat(point.direction()).isEqualTo(-1);
    }
}
