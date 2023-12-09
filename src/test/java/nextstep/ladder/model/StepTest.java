package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StepTest {

    @DisplayName("스텝의 이동여부는 부울 값으로 결정됩니다.")
    @Test
    void stepMovesDeterminedByBoolean(){
        Step step = Step.of(true, false);
        assertThat(step.canMove()).isTrue();
    }

    @DisplayName("첫 스텝의 이전 스텝은 있을 수 없습니다.")
    @Test
    void firstStepIsAlwaysNothing(){
        Step firstStep = Step.first(true);
        assertThat(firstStep.previousStep()).isFalse();
    }

    @DisplayName("마지막 스텝의 현재 스텝은 있을 수 없습니다.")
    @Test
    void lastStepIsAlwaysNothing(){
        Step lastStep = Step.last(true);
        assertThat(lastStep.currentStep()).isFalse();
    }



}
