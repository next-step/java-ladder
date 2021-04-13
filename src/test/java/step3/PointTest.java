package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Location;
import step2.domain.Point;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("현재 위치를 가져오는 테스트")
    void currentPointTest() {
        Point point = new Point(1, new Location(true, false));
        assertThat(point.currentPoint()).isEqualTo(new Point(1, new Location(true, false)));
    }

    @Test
    @DisplayName("현재 위치에서 오른쪽으로 움직이는 테스트")
    public void rightMoveTest() {
        Point point = new Point(1, new Location(false, true));
        assertThat(point.move()).isEqualTo(2);
    }

    @Test
    @DisplayName("현재 위치에서 왼쪽으로 움직이는 테스트")
    public void leftMoveTest() {
        Point point = new Point(1, new Location(true, false));
        assertThat(point.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("현재 위치에서 움직이지 않는 테스트")
    public void notMoveTest() {
        Point point = new Point(1, new Location(false, false));
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("첫 번째 포인트 테스트")
    void firstTest() {
        Point point = Point.first(true);
        assertThat(point).isEqualTo(new Point(0, new Location(false, true)));
    }

    @Test
    @DisplayName("첫번째 값이 있고 다음 포인트 움직이는 테스트")
    void moveToNextPoint() {
        Point secondPoint = Point.first(false).next(false);
        assertThat(secondPoint.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("첫번째 값이 있고 오른쪽에 선이 있다면 오른쪽으로 움직이는 테스트")
    void moveToExistLineToRight() {
        Point secondPoint = Point.first(false).next(true);
        assertThat(secondPoint.move()).isEqualTo(2);
    }

    @Test
    @DisplayName("두번쨰 값이 있고 왼쪽에 선이 있다면 왼쪽으로 움직이는 테스트")
    void moveToExistLineToLeft() {
        Point secondPoint = Point.first(true).next(false);
        assertThat(secondPoint.move()).isEqualTo(0);
    }
}
