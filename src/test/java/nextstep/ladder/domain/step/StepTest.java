package nextstep.ladder.domain.step;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StepTest {
    @DisplayName("가로 라인 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void createStep(int position) {
        assertThat(new Step(position, position)).isNotNull();
    }

    @DisplayName("다음 라인 이동 가능 여부 판단")
    @ParameterizedTest
    @CsvSource(value = {"1,2", "1,1", "2,2"})
    void mavableNextLine(int stepPosition, int linePosition) {
        Step step = new Step(linePosition, stepPosition, () -> true);

        assertThat(step.isMovable(linePosition + 1)).isTrue();
    }

    @DisplayName("이전 라인으로 이동 가능 여부 판단")
    @ParameterizedTest
    @CsvSource(value = {"1,2", "1,1", "2,2"})
    void mavablePrevLine(int stepPosition, int linePosition) {
        Step step = new Step(linePosition - 1, stepPosition, () -> true);

        assertThat(step.isMovable(linePosition)).isTrue();
    }

    @DisplayName("다음 스텝으로 이동")
    @ParameterizedTest
    @CsvSource(value = {"1,2", "1,1", "2,2"})
    void moveNextStep(int stepPosition, int linePosition) {
        Step step = new Step(linePosition, stepPosition, () -> false);

        Step movedStep = step.move();

        assertThat(movedStep.getStepPosition()).isEqualTo(stepPosition + 1);
    }

    @DisplayName("다음 라인으로 이동")
    @ParameterizedTest
    @CsvSource(value = {"1,2", "1,1", "2,2"})
    void moveNextLine(int stepPosition, int linePosition) {
        Step step = new Step(linePosition, stepPosition, () -> true);

        Step movedStep = step.move();

        assertThat(movedStep.getLinePosition()).isEqualTo(linePosition + 1);
    }
}
