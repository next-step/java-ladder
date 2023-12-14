package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.view.Output;
import nextstep.ladder.view.OutputView;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    @Test
    void 사다리의_형태는_그림으로_출력해야한다() {
        OutputView outputView = new OutputView(new Output());
        Ladder ladder = new Ladder(List.of(new Line(List.of(true, false, true)), new Line(List.of(true, false, false))), List.of("a", "b", "c"));
        assertThat(outputView.stringLadder(ladder)).contains("     |-----|     |-----|", "     |-----|     |     |");
    }
}