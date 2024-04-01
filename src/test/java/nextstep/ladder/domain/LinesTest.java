package nextstep.ladder.domain;

import nextstep.ladder.data.StepType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LinesTest {

    @DisplayName("게임의 결과를 받을 수 있다.")
    @Test
    void getGameResult() {
        // given
        LineStrategy customStrategy = (count) -> Line.of(List.of(StepType.STEP, StepType.EMPTY, StepType.STEP, StepType.EMPTY));
        Lines lines = Lines.of(Floor.from(3), 5, customStrategy);

        // when
        List<Integer> integers = lines.gameResult(5);
        System.out.println(integers);

        // then
        Assertions.assertThat(integers).containsExactly(
                1, 0, 3, 2, 4
        );
    }

    @DisplayName("사용자 수가 2명 미만이면 IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionLessThan1User() {
        // then
        LineStrategy customStrategy = (count) -> Line.of(List.of(StepType.STEP, StepType.EMPTY, StepType.STEP, StepType.EMPTY));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lines.of(Floor.from(3), 1, customStrategy));
    }


    @DisplayName("사용자의 수는 항상 Lines의 StepType 수 보다 항상 1 많다. 아니라면 IllegalArguemntException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionBetweenUserCountAndLine() {
        LineStrategy customStrategy = (count) -> Line.of(List.of(StepType.STEP, StepType.EMPTY, StepType.STEP, StepType.EMPTY));

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lines.of(Floor.from(3), 1, customStrategy));
    }
}
