package nextstep.ladder.domain;

import nextstep.ladder.data.StepType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LinesTest {

    @DisplayName("게임의 결과를 받을 수 있다.")
    @Test
    void getGameResult() {
        // given
        LineStrategy customStrategy = (count) -> Line.of(5, List.of(StepType.STEP, StepType.EMPTY, StepType.STEP, StepType.EMPTY));
        Lines lines = Lines.of(Floor.from(3), 5, customStrategy);

        // when
        List<Integer> integers = lines.gameResult(5);
        System.out.println(integers);

        // then
        Assertions.assertThat(integers).containsExactly(
                1, 0, 3, 2, 4
        );
    }
}
