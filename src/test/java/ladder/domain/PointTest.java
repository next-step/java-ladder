package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("포인트가 이동할 곳이 없다면 해당 인덱스에 멈추게 된다.")
    void stay() {
        Point newPoint = new Point(false, false);
        assertThat(newPoint.move()).isEqualTo(Direction.STAY);
    }

    @Test
    @DisplayName("포인트가 오른쪽으로 이동이 가능하다면 오른쪽으로 이동한다.")
    void right() {
        Point newPoint = new Point(false, true);
        assertThat(newPoint.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("포인트가 왼쪽으로 이동이 가능하다면 왼쪽으로 이동한다.")
    void left() {
        Point newPoint = new Point(true, false);
        assertThat(newPoint.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("시작점은 항상 왼쪽은 false 오른쪽은 랜덤으로 정해진 값으로 생성된다.")
    void createFirstPoint() {
        Point point = Point.createFirstPoint(() -> true);

        assertThat(point).isEqualTo(new Point(false, true));
    }

    @Test
    @DisplayName("마지막점은 항상 오른쪽은 false 왼쪽은 이전 포인트의 위치 값으로 생성된다.")
    void createLastPoint() {
        Point point = new Point(false, true);
        Point lastPoint = point.createLastPoint();


        assertThat(lastPoint).isEqualTo(new Point(true, false));
    }

    @Test
    @DisplayName("이전의 선이 true라면 다음 선은 true가 될 수 없으며 무조건 false 이다.")
    void createNextLine_before_true() {
        Point nextPoint = Point.createNextPoint(true, () -> true);

        assertThat(nextPoint).isEqualTo(new Point(true, false));
    }

    @Test
    @DisplayName("이전의 선이 false 라면 다음 선은 랜덤하게 생성될 수 있다.")
    void createNextLine_before_false() {
        Point nextPoint = Point.createNextPoint(false, () -> true);

        assertThat(nextPoint).isEqualTo(new Point(false, true));
    }
}
