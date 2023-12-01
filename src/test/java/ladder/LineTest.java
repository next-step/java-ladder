package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ladder.model.Ladder;
import ladder.model.Line;
import ladder.model.Point;
import ladder.model.PointRandomStrategy;
import ladder.teststrategy.PointFalseStrategy;
import ladder.teststrategy.PointTrueStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {3,4,5,6,7,8})
    @DisplayName("가로 point를 생성할 때 게임플레이어 숫자보다 1 작은 수 만큼 포인트 공간을 생성한다.")
    void linePointTest(int playerCount) {
        Line line = Line.create(playerCount, new PointRandomStrategy());
        assertThat(line.getPoints().size()).isEqualTo(playerCount-1);
    }

    @ParameterizedTest
    @ValueSource(ints = {2,3,4,5})
    @DisplayName("랜덤으로 나온 값이 true라면 가로 포인트를 그린다.")
    void linePointGenerateTest(int playerCount) {
        Line line = Line.create(playerCount, new PointTrueStrategy());
        assertThat(line.getPoints().get(0).toString()).isEqualTo(Ladder.LINE_WITH_POINTS.getShape());
    }

    @ParameterizedTest
    @ValueSource(ints = {2,3,4,5})
    @DisplayName("랜덤으로 나온 값이 false라면 가로 포인트를 그리지 않는다.")
    void linePointNotGenerateTest(int playerCount) {
        Line line = Line.create(playerCount, new PointFalseStrategy());
        assertThat(line.getPoints().get(0).toString()).isEqualTo(Ladder.LINE_ONLY.getShape());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    @DisplayName("아직 그려진 포인트가 없거나 사다리의 첫 시작점이라면 이전 포인트가 없으므로 false 상태 리턴한다.")
    void isPreviousPointExistTest(int playerCount) {
        Line.create(playerCount, new PointRandomStrategy());
        assertThat(Line.isPreviousPointExist(List.of(new Point()), 0).getStatus()).isEqualTo(new Point(false).getStatus());
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    @DisplayName("시작점 0에서 사다리 가로포인트가 그려져있다면 위치를 1칸 이동한다.")
    void moveTest(int startPosition) {
        Line line = Line.create(3, new PointTrueStrategy());
        int position = line.move(startPosition);
        assertThat(position).isEqualTo(1);
    }
}
