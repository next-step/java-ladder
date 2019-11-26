package reladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reladder.domain.Direction;
import reladder.domain.Point;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    private Point point;

    @BeforeEach
    void setUp() {
        point = new Point(0, Direction.first(true));
    }

    @Test
    @DisplayName("같은 값일 때 객체의 내용 비교")
    void pointEqualsWhenSameValue() {
        // give
        Point newPoint = new Point(0, Direction.first(true));
        // when
        boolean isSame = point.equals(newPoint);
        // then
        assertThat(isSame).isTrue();
    }

    @Test
    @DisplayName("방향 값에 따라 인덱스 추출 테스트")
    void pointMoveTest() {
        // give
        Point rightPoint = new Point(1, Direction.first(true));
        Point rightPointIndexTwo = new Point(2, Direction.first(true));
        Point lefPoint = new Point(2, Direction.of(true, false));
        Point stayPoint = new Point(2, Direction.of(false, false));
        // when
        int rightMove = rightPoint.move();
        int rightMoveIndexTwo = rightPointIndexTwo.move();
        int leftMove = lefPoint.move();
        int stayMove = stayPoint.move();
        // then
        assertThat(rightMove).isEqualTo(2);
        assertThat(rightMoveIndexTwo).isEqualTo(3);
        assertThat(leftMove).isEqualTo(1);
        assertThat(stayMove).isEqualTo(2);
    }

    @Test
    @DisplayName("다음 포인트 객체 생성 테스트")
    void nextPointObjectTest() {
        // give
        Point point = new Point(0, Direction.first(true));
        Point nextPoint = point.next(false);
        // when
        boolean isSame = nextPoint.equals(new Point(1, Direction.of(true, false)));
        // then
        assertThat(isSame).isTrue();
    }

    @Test
    @DisplayName("첫 시작 객체 생성 테스트")
    void nextPointObjectFirstTest() {
        // give
        Point point = Point.firstNext(true); // true true 안됨 -> true false
        Point nextPoint = point.next(false);
        // when
        int index = nextPoint.move();
        // then
        assertThat(index).isEqualTo(0);
    }
}
