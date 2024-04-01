package nextstep.ladder.domain;

import nextstep.ladder.data.StepType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class LineTest {

    @DisplayName("이전 사다리의 발판(step)이 존재하면, 다음은 step이 없어야 한다. 전략이 맞지 않다면, IllegalArugmentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionIfStepContinued() {
        // then
        Assertions.assertThatThrownBy(() -> Line.of(List.of(StepType.STEP, StepType.STEP, StepType.STEP, StepType.STEP)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자 수의 -1 만큼 위치가 존재한다.")
    @Test
    void sizeAsCountOfUsers() {
        Line line = Line.of(List.of(StepType.STEP, StepType.EMPTY, StepType.STEP, StepType.EMPTY));

        // then
        assertThat(line.toList()).hasSize(4);
    }

    @DisplayName("시작 전 위치를 주면, 현재 Line에 대한 이동 시 결과를 반환한다.")
    @Test
    void getDestinationPointFromDepartPoint() {
        Line line = Line.of(List.of(StepType.STEP, StepType.EMPTY, StepType.STEP, StepType.EMPTY));
        // then
        assertAll(
            () -> assertThat(line.getDestinationFrom(0)).isEqualTo(1),
            () -> assertThat(line.getDestinationFrom(1)).isEqualTo(0),
            () -> assertThat(line.getDestinationFrom(2)).isEqualTo(3),
            () -> assertThat(line.getDestinationFrom(3)).isEqualTo(2),
            () -> assertThat(line.getDestinationFrom(4)).isEqualTo(4)
        );
    }
}
