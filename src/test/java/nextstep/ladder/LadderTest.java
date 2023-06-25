package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Size;
import nextstep.ladder.handler.LadderHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    LadderHandler ladderHandler = new LadderHandler();

    @Test
    @DisplayName("라인만드는테스트")
    public void makeLine() {
        Ladder ladder = ladderHandler.makeLines(new Size(3, 4));
        assertThat(ladder).isInstanceOf(Ladder.class);
        assertThat(ladder.lines()).hasSize(4);
    }
}
