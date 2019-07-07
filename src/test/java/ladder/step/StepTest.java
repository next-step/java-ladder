package ladder.step;

import ladder.view.constant.Step;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepTest {
    @Test
    @DisplayName("[success] 다음 스텝을 정상적으로 설정할 수 있다.")
    void test() {
        //Given
        Step nextStep = Step.REWARD_INPUT_STEP;
        
        //When
        Step.setNextStep(nextStep);
        
        //Then
        Assertions.assertThat(Step.isThisStep(nextStep)).isTrue();
    }
}
