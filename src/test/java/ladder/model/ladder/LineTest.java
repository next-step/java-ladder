package ladder.model.ladder;

import ladder.model.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    @DisplayName("point의 size 값 맞는지 테스트")
    void drawSizeTest(int countOfPerson) {
        Line line = Line.init(countOfPerson);
        assertThat(line.points().get().size()).isEqualTo(countOfPerson);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("point 움직이는 것 테스트, 선이 왼쪽에 있으면 point index - 1")
    public void pointMoveLeftTest(int moveIndex) {
        Line line = Line.init(4);
        Point point = line.points().get().get(moveIndex);
        if(point.isLeft()) {
            assertThat(line.move(moveIndex)).isEqualTo(moveIndex -1);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("point 움직이는 것 테스트, 선이 오른쪽에 있으면 오른쪽으로 이동 point index + 1")
    public void pointMoveRightTest(int moveIndex) {
        Line line = Line.init(4);
        Point point = line.points().get().get(moveIndex);
        if(point.isRight()) {
            assertThat(line.move(moveIndex)).isEqualTo(moveIndex + 1);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("point 움직이는 것 테스트, 선이 왼쪽과 오른쪽에 모두 없으면 index 유지")
    public void pointNotMoveTest(int moveIndex) {
        Line line = Line.init(4);
        Point point = line.points().get().get(moveIndex);
        if(!point.isRight() && !point.isLeft()) {
            assertThat(line.move(moveIndex)).isEqualTo(moveIndex);
        }
    }
}
