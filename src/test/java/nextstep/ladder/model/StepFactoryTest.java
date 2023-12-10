package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import nextstep.ladder.test.TestRandomLineGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;

class StepFactoryTest {

    TestRandomLineGenerator randomLineGenerator = new TestRandomLineGenerator();

    @DisplayName("첫 스텝의 이전스텝은 없습니다.")
    @RepeatedTest(10)
    void firstStepHavePreviousStepThatAlwaysFalse() {
        StepFactory stepFactory = new StepFactory();
        Step firstStep = stepFactory.firstStep(randomLineGenerator);
        assertThat(firstStep.previousStep()).isFalse();
    }

    @DisplayName("마지막 스텝의 현재스텝은 없습니다")
    @RepeatedTest(10)
    void lastStepHaveCurrentStepThatAlwaysFalse() {
        StepFactory stepFactory = new StepFactory();
        Step lastStep = stepFactory.lastStep(true);
        assertThat(lastStep.currentStep()).isFalse();
    }

    @DisplayName("이전스텝이 True면 언제나 현재스텝이 False인 스텝을 만듭니다.")
    @RepeatedTest(10)
    void previousStepIsTrueThenAlwaysCreatedCurrentStepIsFalse() {
        StepFactory stepFactory = new StepFactory();
        Step step = stepFactory.createStep(true, randomLineGenerator);
        assertThat(step.currentStep()).isFalse();
    }

}
