package nextstep.ladder.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StepTypeTest {

    @DisplayName("Boolean 타입을 받으면 해당되는 StepType을 반환한다.")
    @Test
    void getStepTypeOfBooleanType() {
        // then
        assertThat(StepType.from(true)).isEqualTo(StepType.STEP);
        assertThat(StepType.from(false)).isEqualTo(StepType.EMPTY);
    }
}
