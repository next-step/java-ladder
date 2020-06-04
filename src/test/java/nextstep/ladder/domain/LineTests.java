package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.PointsNeedMoreThanOnePersonException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTests {
    private PointAddStrategy simplePointAddStrategy;

    @BeforeEach
    public void setup() {
        simplePointAddStrategy = new SimplePointAddStrategy();
    }

    @DisplayName("참여하는 인원수를 입력받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        int countOfPerson = 3;
        Line line = LineFactory.create(countOfPerson, simplePointAddStrategy);
        assertThat(line).isNotNull();
    }

    @DisplayName("0이하의 인원수로 객체를 생성 할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void createValidationTest(int invalidCountOfPerson) {
        assertThatThrownBy(() -> LineFactory.create(invalidCountOfPerson, simplePointAddStrategy))
                .isInstanceOf(PointsNeedMoreThanOnePersonException.class);
    }

    @DisplayName("첫번째 칸에는 무조건 다리를 놓을 수 없다.")
    @Test
    void firstLadderMustFalseTest() {
        int countOfPerson = 1;
        Line line = LineFactory.create(countOfPerson, simplePointAddStrategy);
        assertThat(line.size()).isEqualTo(1);
        assertThat(line.getPointsIndex(0)).isFalse();
    }

    @DisplayName("다리가 없는 칸 다음의 칸에는 다리를 놓을 수 있다.")
    @Test
    void canMakeLadderAfterNoneLadder() {
        int countOfPerson = 2;
        Line line = LineFactory.create(countOfPerson, simplePointAddStrategy);
        assertThat(line.size()).isEqualTo(2);
        assertThat(line.getPointsIndex(0)).isFalse();
        assertThat(line.getPointsIndex(1)).isTrue();
    }

    @DisplayName("이전칸에 다리가 놓였다면 이후 칸에는 다리를 놓을 수 없다.")
    @Test
    void cantMakeLadderAfterLadder() {
        int countOfPerson = 3;
        Line line = LineFactory.create(countOfPerson, simplePointAddStrategy);
        assertThat(line.size()).isEqualTo(3);
        assertThat(line.getPointsIndex(0)).isFalse();
        assertThat(line.getPointsIndex(1)).isTrue();
        assertThat(line.getPointsIndex(2)).isFalse();
    }

    @DisplayName("전달된 index의 Point가 true일 경우 왼쪽으로 이동")
    @ParameterizedTest
    @CsvSource(value = "3:1", delimiter = ':')
    void moveLeftTest(int countOfPerson, int pointIndex) {
        Line line = LineFactory.create(countOfPerson, simplePointAddStrategy);

        assertThat(line.whereToMove(pointIndex)).isEqualTo(HorizontalMoveStrategy.MOVE_LEFT);
    }

    @DisplayName("전달된 index의 오른쪽 Point가 true일 경우 오른쪽으로 이동")
    @ParameterizedTest
    @CsvSource(value = "3:0", delimiter = ':')
    void moveRightTest(int countOfPerson, int pointIndex) {
        Line line = LineFactory.create(countOfPerson, simplePointAddStrategy);

        assertThat(line.whereToMove(pointIndex)).isEqualTo(HorizontalMoveStrategy.MOVE_RIGHT);
    }

    @DisplayName("전달된 index가 Line index의 마지막이고, 해당 index가 true인 경우 왼쪽으로 이동")
    @ParameterizedTest
    @CsvSource(value = "4:3", delimiter = ':')
    void lastIndexMoveLeftTest(int countOfPerson, int pointIndex) {
        Line line = LineFactory.create(countOfPerson, simplePointAddStrategy);

        assertThat(line.whereToMove(pointIndex)).isEqualTo(HorizontalMoveStrategy.MOVE_LEFT);
    }

    @DisplayName("전달된 index가 Line index의 마지막이고, 해당 index가 false인 경우 움직이지 않음")
    @ParameterizedTest
    @CsvSource(value = "3:2", delimiter = ':')
    void lastIndexStayTest(int countOfPerson, int pointIndex) {
        Line line = LineFactory.create(countOfPerson, simplePointAddStrategy);

        assertThat(line.whereToMove(pointIndex)).isEqualTo(HorizontalMoveStrategy.STAY);
    }
}
