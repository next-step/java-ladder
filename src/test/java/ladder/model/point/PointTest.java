package ladder.model.point;

import ladder.model.direction.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class PointTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    @DisplayName("right이 true일때 index + 1 되는 것 테스트")
    void pointMoveIndexPlusTest(int index) {
        Point point = new Point(index, Direction.of(false,true));
        assertThat(point.move()).isEqualTo(index + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {2,3,4,5})
    @DisplayName("left가 true일때 index -1 되는 것 테스트")
    void pointMoveIndexMinusTest(int index) {
        Point point = new Point(index, Direction.of(true,false));
        assertThat(point.move()).isEqualTo(index -1);
    }

    @ParameterizedTest
    @ValueSource(ints = {2,3,4,5})
    @DisplayName("다음 포인트로 이동 테스트")
    void pointNextTest(int index) {
        Direction direction = Direction.of(false,true);
        Point point1 = new Point(index, direction);
        Point point2 = new Point(index + 1 ,direction.next(true));
        assertThat(point1.next(true)).isEqualTo(point2);
    }

    @Test
    @DisplayName("first 이동 테스트")
    public void first() {
        assertThat(Point.first(true).move()).isEqualTo(1);
        assertThat(Point.first(false).move()).isEqualTo(0);
    }

    @Test
    @DisplayName("왼쪽 오른쪽 모두 선이 없을때 위치 동일한 것 테스트")
    public void next_stay() {
        Point second = Point.first(false).next(false);
        assertThat(second.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("point의 오른쪽에 선이 있을 때 오른쪽으로 이동 테스트")
    public void next_move_right() {
        Point second = Point.first(false).next(true);
        assertThat(second.move()).isEqualTo(2);
    }

    @Test
    @DisplayName("point의 왼쪽에 선이 있을 때 왼쪽으로 이동 테스트")
    public void next_move_left() {
        Point second = Point.first(true).next(false);
        assertThat(second.move()).isEqualTo(0);
    }
}
