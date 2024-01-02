package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.strategy.ManualGeneratePointStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    void 사다리는_높이가_1_이상_이여야_한다() {
        assertThatThrownBy(() -> new Ladder(2, 0, ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리는 높이가 1 이상이여야 합니다");
    }

    @Test
    void 사다리의_위치의_결과를_노출한다() {
        ManualGeneratePointStrategy strategy = new ManualGeneratePointStrategy(List.of(false, false));
        List<Line> lines = List.of(new Line(strategy), new Line(strategy));
        Ladder ladder = new Ladder(lines, List.of("a", "b"));
        assertThat(ladder.getLadderResult(0)).isEqualTo("a");
    }
}