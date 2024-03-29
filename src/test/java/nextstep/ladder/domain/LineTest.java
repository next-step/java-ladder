package nextstep.ladder.domain;

import nextstep.ladder.data.StepType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class LineTest {

    @DisplayName("이전 사다리의 발판(step)이 존재하면, 다음은 step이 없어야 한다.")
    @Test
    void emptyStepTypeWhenBeforeStepTypeIsNotEmpty() {
        // given
        int countOfUsers = 5;
        StepStrategy strategy = (count) -> List.of(StepType.STEP, StepType.STEP, StepType.STEP, StepType.STEP);
        Line line = Line.of(countOfUsers, strategy);

        // then
        assertThat(line.toList()).isEqualTo(List.of(StepType.STEP, StepType.EMPTY, StepType.STEP, StepType.EMPTY));
    }

    @DisplayName("참여자 수의 -1 만큼 위치가 존재한다.")
    @Test
    void sizeAsCountOfUsers() {
        StepStrategy strategy = (countOfUsers) -> List.of(StepType.STEP, StepType.STEP, StepType.STEP, StepType.STEP);
        int countOfUsers = 5;
        Line line = Line.of(countOfUsers, strategy);

        // then
        assertThat(line.toList()).hasSize(4);
    }

    @DisplayName("사용자 수가 2명 미만이면 IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionLessThan1User() {
        StepStrategy strategy = (countOfUsers) -> List.of(StepType.STEP);
        int countOfUsers = 1;

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.of(countOfUsers, strategy));
    }

    @DisplayName("사용자의 수는 항상 Line의 StepType 수 보다 항상 1 많다. 아니라면 IllegalArguemntException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionBetweenUserCountAndLine() {
        StepStrategy strategy = (countOfUsers) -> List.of(StepType.STEP, StepType.EMPTY, StepType.STEP);
        int countOfUsers = 3;

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.of(countOfUsers, strategy));
    }
}
