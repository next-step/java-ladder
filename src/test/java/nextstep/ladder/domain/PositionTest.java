package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("이동하지 않음 테스트")
    void dontMoveTest(int input) {
        Step step = Step.firstStep(false);
        Position position = new Position(input, step);

        assertThat(position.move())
                .isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("왼쪽으로 이동 테스트")
    void leftMoveTest(int input) {
        Step step = Step.firstStep(true).nextStep(false);
        Position position = new Position(input, step);

        assertThat(position.move())
                .isEqualTo(input - 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0 ,1, 2})
    @DisplayName("오른쪽으로 이동 테스트")
    void rightMoveTest(int input) {
        Step step = Step.firstStep(true);
        Position position = new Position(input, step);

        assertThat(position.move())
                .isEqualTo(input + 1);
    }
}
