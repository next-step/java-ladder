package nextstep.ladder.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StepTypeTest {

    @DisplayName("Boolean 타입을 받으면 해당되는 StepType을 반환한다.")
    @Test
    void getStepTypeOfBooleanType() {
        // then
        assertThat(StepType.of(true)).isEqualTo(StepType.STEP);
        assertThat(StepType.of(false)).isEqualTo(StepType.EMPTY);
    }

    @DisplayName("StepType을 받으면 해당되는 draw를 반환한다.")
    @Test
    void getDrawOfStepType() {
        // then
        assertThat(StepType.drawOf(StepType.STEP)).isEqualTo("-----");
        assertThat(StepType.drawOf(StepType.EMPTY)).isEqualTo("     ");
    }
}
