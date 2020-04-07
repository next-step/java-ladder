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
    void createStep() {
        assertThat(Step.imMovable()).isNotNull();
    }

    @DisplayName("라인이 겹치지 않도록 이동 가능 여부 판단")
    @ParameterizedTest
    @CsvSource(value = {"1,2", "1,1", "2,2"})
    void mavableNextLine(int stepPosition, int linePosition) {
        Step step = Step.movableNext(linePosition, stepPosition, () -> true);

        assertThat(step.isMovableLine(linePosition + 1)).isTrue();
    }

    @DisplayName("이전 라인으로 이동 가능 여부 판단")
    @ParameterizedTest
    @CsvSource(value = {"1,2", "1,1", "2,2"})
    void mavablePrevLine(int stepPosition, int linePosition) {
        Step step = Step.movablePrev(linePosition, stepPosition, () -> true);

        assertThat(step.isMovableLine(linePosition - 1)).isTrue();
    }
}