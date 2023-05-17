package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StepTest {

    @Test
    @DisplayName("이동하지 않음")
    void dontMoveTest() {
        Step step = Step.firstStep(false).nextStep(false);

        assertThat(step.isRight())
                .isFalse();

        assertThat(step.isLeft())
                .isFalse();
    }

    @Test
    @DisplayName("왼쪽으로 이동")
    void leftMoveTest() {
        Step step = Step.firstStep(true).nextStep(false);

        assertThat(step.isLeft())
                .isTrue();
    }

    @Test
    @DisplayName("오른쪽으로 이동")
    void rightMoveTest() {
        Step step = Step.firstStep(false).nextStep(true);

        assertThat(step.isRight())
                .isTrue();
    }

    @Test
    @DisplayName("이전 값이 true인데 다음 값이 true일 때 예외 처리")
    void onlyTrueErrorTest() {
        assertThatThrownBy(() -> Step.firstStep(true).nextStep(true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("선이 연속으로 생길 수 없습니다.");
    }

    @Test
    @DisplayName("첫번째 포지션 입력")
    void firstStepTest() {
        Step step1 = Step.firstStep(false);

        assertThat(step1.isRight())
                .isFalse();
        assertThat(step1.isLeft())
                .isFalse();

        Step step2 = Step.firstStep(true);

        assertThat(step2.isRight())
                .isTrue();
    }

    @Test
    @DisplayName("마지막 포지션 입력")
    void nextStepTest() {
        Step step1 = Step.firstStep(false).lastStep();

        assertThat(step1.isRight())
                .isFalse();
        assertThat(step1.isLeft())
                .isFalse();

        Step step2 = Step.firstStep(true).lastStep();

        assertThat(step2.isLeft())
                .isTrue();
    }

    @Test
    @DisplayName("현재 스텝이 그려졌는지 확인")
    void hasPreviousStepTest() {
        Step step = Step.firstStep(true);

        assertThat(step.isRight())
                .isTrue();
    }

}
