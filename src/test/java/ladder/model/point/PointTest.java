package ladder.model.point;

import ladder.model.direction.Direction;
import org.junit.jupiter.api.DisplayName;
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
        Point point1 = new Point(index,direction);
        Point point2 = new Point(index + 1 ,direction.next());
        assertThat(point1.next()).isEqualTo(point2);
    }
}