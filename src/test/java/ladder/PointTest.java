package ladder;

import ladder.model.Point;
import ladder.model.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PointTest {
    @DisplayName("좌,우 라인이 겹칠 경우 생성할 수 없다")
    @Test
    void createFail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Point(1, true, true));
    }

    @DisplayName("좌측에 라인이 있는 경우 좌측으로 이동한다")
    @Test
    void left() {
        Point point = new Point(1, true, false);
        assertThat(point.move()).isEqualTo(0);
    }

    @DisplayName("우측에 라인이 있는 경우 우측으로 이동한다")
    @Test
    void right() {
        Point point = new Point(1, false, true);
        assertThat(point.move()).isEqualTo(2);
    }

    @DisplayName("양쪽 모두 라인이 없는 경우 이동하지 않는다")
    @Test
    void pass() {
        Point point = new Point(1, false, false);
        assertThat(point.move()).isEqualTo(1);
    }

    @DisplayName("각 라인의 첫번째 Point를 생성할 수 있다")
    @Test
    void firstPoint() {
        Point point = Point.createFirst(true);
        assertThat(point).isEqualTo(new Point(0, false, true));
    }

    @DisplayName("각 라인의 마지막 Point를 생성할 수 있다")
    @Test
    void lastPoint() {
        Point point = new Point(1, false, true);
        Point lastPoint = point.createLast();
        assertThat(lastPoint).isEqualTo(new Point(2, true, false));
    }

    @DisplayName("현재 Point에서 다음 위치의 Point를 생성할 수 있다")
    @Test
    void nextPoint() {
        Point point = new Point(1, true, false);
        Point nextPoint = point.createNext(true);
        assertThat(nextPoint).isEqualTo(new Point(2, false, true));
    }
}
