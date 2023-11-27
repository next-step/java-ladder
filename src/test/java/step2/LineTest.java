package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.model.Ladder;
import step2.model.Line;
import step2.model.Point;
import step2.model.PointRandomStrategy;
import step2.teststrategy.PointFalseStrategy;
import step2.teststrategy.PointTrueStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {3,4,5,6,7,8})
    @DisplayName("가로 point를 생성할 때 게임플레이어 숫자보다 1 작은 수 만큼 포인트 공간을 생성한다.")
    void linePointTest(int playerCount) {
        Line line = new Line(playerCount, new PointRandomStrategy());
        assertThat(line.getPoints().size()).isEqualTo(playerCount-1);
    }

    @ParameterizedTest
    @ValueSource(ints = {2,3,4,5})
    @DisplayName("랜덤으로 나온 값이 true라면 가로 포인트를 그린다.")
    void linePointGenerateTest(int playerCount) {
        Line line = new Line(playerCount, new PointTrueStrategy());
        assertThat(line.getPoints().get(0).toString()).isEqualTo(Ladder.LINE_WITH_POINTS.getShape());
    }

    @ParameterizedTest
    @ValueSource(ints = {2,3,4,5})
    @DisplayName("랜덤으로 나온 값이 false라면 가로 포인트를 그리지 않는다.")
    void linePointNotGenerateTest(int playerCount) {
        Line line = new Line(playerCount, new PointFalseStrategy());
        assertThat(line.getPoints().get(0).toString()).isEqualTo(Ladder.LINE_ONLY.getShape());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    @DisplayName("아직 그려진 포인트가 없거나 사다리의 첫 시작점이라면 이전 포인트가 없으므로 null을 리턴한다.")
    void isPreviousPointExistTest(int playerCount) {
        Line line = new Line(playerCount, new PointRandomStrategy());
        assertThat(line.isPreviousPointExist(List.of(new Point()), 0)).isEqualTo(null);
    }
}
