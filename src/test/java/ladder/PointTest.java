package ladder;

import ladder.domain.Direction;
import ladder.domain.FirstPointStrategy;
import ladder.domain.Point;
import ladder.domain.PointStrategy;
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

    @DisplayName("포인트가 오른쪽 방향을 가지고 있다면 true를 반환한다.")
    @Test
    void hasRightDirection() {
        Point point = new Point(0, new Direction(false, true));
        assertThat(point.hasRightDirection()).isTrue();
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

    @DisplayName("양쪽 방향이 없을경우 자신의 인덱스를 반환한다.")
    @Test
    void pass() {
        PointStrategy strategy = new FirstPointStrategy(false);
        Point secondPoint = strategy.point().next(false);

        assertThat(secondPoint.move()).isEqualTo(1);
    }

    @DisplayName("왼쪽 방향의 경우 자신의 이전 인덱스를 반환한다.")
    @Test
    void left() {
        PointStrategy strategy = new FirstPointStrategy(true);
        Point secondPoint = strategy.point().next(false);

        assertThat(secondPoint.move()).isEqualTo(0);
    }

    @DisplayName("오른쪽 방향의 경우 자신의 다음 인덱스를 반환한다.")
    @Test
    void right() {
        PointStrategy strategy = new FirstPointStrategy(false);
        Point secondPoint = strategy.point().next(true);

        assertThat(secondPoint.move()).isEqualTo(2);
    }
}
