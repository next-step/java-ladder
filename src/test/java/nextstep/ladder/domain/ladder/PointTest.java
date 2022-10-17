package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {

    @DisplayName("왼쪽 오른쪽 동시에 열릴 수 없다.")
    @Test
    void biPoint() {
        assertThatThrownBy(() -> new Point(1, true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("첫번째 점은 왼쪽이 닫혀있다.")
    @Test
    void firstPoint() {
        Point first = Point.first(() -> true);

        assertThat(first.hasLeft()).isFalse();
    }

    @DisplayName("이전 점의 왼쪽이 열려있는 경우 다음 점의 왼쪽은 닫혀있다.")
    @Test
    void nextPoint1() {
        Point prevPoint = new Point(1, true, false);
        Point nextPoint = Point.nextOf(prevPoint, () -> true);

        assertThat(nextPoint.hasLeft()).isFalse();
    }

    @DisplayName("이전 점의 오른쪽이 열려있는 경우 다음 점의 왼쪽은 열려있고 오른쪽은 닫혀있다.")
    @Test
    void nextPoint2() {
        Point prevPoint = new Point(1, false, true);
        Point nextPoint = Point.nextOf(prevPoint, () -> true);

        assertThat(nextPoint.hasLeft()).isTrue();
        assertThat(nextPoint.hasRight()).isFalse();
    }

    @DisplayName("이전 점의 왼쪽, 오른쪽 모두 열려있지 않은 경우 다음 점의 왼쪽은 닫혀있다.")
    @Test
    void nextPoint3() {
        Point prevPoint = new Point(1, false, false);
        Point nextPoint = Point.nextOf(prevPoint, () -> true);

        assertThat(nextPoint.hasLeft()).isFalse();
    }

    @DisplayName("마지막 점의 오른쪽은 닫혀있다.")
    @Test
    void lastPoint() {
        Point prevPoint = new Point(1, false, true);
        Point lastPoint = Point.lastOf(prevPoint, () -> true);

        assertThat(lastPoint.hasRight()).isFalse();
    }

    @DisplayName("두 점이 나란히 왼쪽 방향을 바라보는지 판단할 수 있다.")
    @Test
    void leftOverlap() {
        Point pointA = new Point(2, false, true);
        Point pointB = new Point(3, false, true);

        assertThat(pointA.isOverlapping(pointB)).isTrue();
    }

    @DisplayName("두 점이 나란히 오른쪽 방향을 바라보는지 판단할 수 있다.")
    @Test
    void rightOverlap() {
        Point pointA = new Point(2, true, false);
        Point pointB = new Point(3, true, false);

        assertThat(pointA.isOverlapping(pointB)).isTrue();
    }

    @DisplayName("거리가 떨어져 있는 경우 같은 방향을 바라보는 것은 상관하지 않는다.")
    @Test
    void noOverlap() {
        Point pointA = new Point(2, true, false);
        Point pointB = new Point(4, true, false);

        assertThat(pointA.isOverlapping(pointB)).isFalse();
    }

    @DisplayName("열려있는 방향을 체크할 수 있다.")
    @Test
    void direction() {
        Point point = new Point(0, true, false);

        assertThat(point.hasLeft()).isTrue();
        assertThat(point.hasRight()).isFalse();
    }

    @DisplayName("열려있는 방향의 점 위치를 반환한다.")
    @Test
    void directionPosition1() {
        Point point = new Point(1, true, false);

        assertThat(point.nextPosition()).isEqualTo(0);
    }

    @DisplayName("열려있는 방향의 점 위치를 반환한다.")
    @Test
    void directionPosition2() {
        Point point = new Point(1, false, true);

        assertThat(point.nextPosition()).isEqualTo(2);
    }
}
