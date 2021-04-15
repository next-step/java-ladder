package ladder;

import ladder.domain.Direction;
import ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @DisplayName("포인트 클래스는 인스턴스를 생성한다.")
    @Test
    void create() {
        assertThat(new Point(0, new Direction(false, false)))
                .isEqualTo(new Point(0, new Direction(false, false)));
    }

    @DisplayName("다음 포인트의 인덱스를 반환한다.")
    @Test
    void nextIndex() {
        Point point = new Point(0, new Direction(false, false));
        assertThat(point.nextIndex()).isEqualTo(1);
    }

    @DisplayName("포인트가 오른쪽 방향을 가지고 있다면 true를 반환한다.")
    @Test
    void hasRightDirection() {
        Point point = new Point(0, new Direction(false, true));
        assertThat(point.hasRightDirection()).isTrue();
    }

    @DisplayName("포인트가 왼쪽 방향을 가지고 있다면 true를 반환한다.")
    @Test
    void hasLeftDirection() {
        Point point = new Point(0, new Direction(true, false));
        assertThat(point.hasLeftDirection()).isTrue();
    }

    @DisplayName("포인트가 왼쪽 또는 오른쪽 방향을 가지고 있다면 true를 반환한다.")
    @Test
    void hasDirection() {
        Point point1 = new Point(0, new Direction(false, true));
        Point point2 = new Point(0, new Direction(true, false));

        assertThat(point1.hasDirection()).isTrue();
        assertThat(point2.hasDirection()).isTrue();
    }

    @DisplayName("포인트가 움직인 후의 결과 인덱스를 반환한다.")
    @Test
    void move() {
        Point point1 = new Point(1, new Direction(false, true));
        Point point2 = new Point(1, new Direction(true, false));
        Point point3 = new Point(1, new Direction(false, false));

        assertThat(point1.move()).isEqualTo(2);
        assertThat(point2.move()).isEqualTo(0);
        assertThat(point3.move()).isEqualTo(1);
    }
}
