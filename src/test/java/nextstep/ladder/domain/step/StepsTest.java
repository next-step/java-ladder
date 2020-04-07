package nextstep.ladder.domain.step;

import nextstep.ladder.domain.step.strategy.RandomMovement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StepsTest {
    @DisplayName("다음 라인으로 이동 가능한 스텝 생성")
    @ParameterizedTest
    @CsvSource(value = {"5,2", "10,3", "7,5"})
    void create(int height, int linePosition) {
        Steps steps = Steps.movableNext(height, linePosition);

        assertThat(steps.getLinePosition()).isEqualTo(linePosition);
    }

    @DisplayName("이전 라인의 상태에 따라 이동 가능한 스텝 생성")
    @ParameterizedTest
    @CsvSource(value = {"5,2", "10,3", "7,5"})
    void createByPreviousStep(int height, int linePosition) {
        Steps createdSteps = Steps.movableNext(height, linePosition);
        Steps steps = Steps.movableByPreviousCondition(createdSteps,
                ((previouSteps, linPosition, stepPosition) -> Step.movableNext(linePosition, stepPosition, () -> true)));

        assertAll(
                () -> steps.getSteps()
                        .forEach(step -> assertThat(step.isMovableLine(linePosition)))
        );
    }

    @DisplayName("라인 위치가 음수 일때 생성 실패")
    @ParameterizedTest
    @CsvSource(value = {"5,-2", "10,-3", "7,-5"})
    void createFailByNegativePosition(int height, int linePosition) {
        assertThatIllegalArgumentException().isThrownBy(() -> Steps.movableNext(height, linePosition));
    }
}