package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    void 사다리의_형태는_그림으로_출력해야한다() {
        OutputView outputView = new OutputView();
        Ladder ladder = new Ladder(List.of(new Line(List.of(true, false, true)), new Line(List.of(true, false, false))));
        assertThat(outputView.stringLadder(ladder)).contains("     |-----|     |-----|", "     |-----|     |     |");
    }
}