package ladder.domain.ladder.ladderline;

import ladder.domain.ladder.Ladder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderLinesTest {

    @Test
    void create() {
        LadderLines ladderLines = new LadderLines(List.of(new LadderLine(List.of(Ladder.NONE,Ladder.NONE))));

        assertThat(ladderLines).isEqualTo(new LadderLines(List.of(new LadderLine(List.of(Ladder.NONE,Ladder.NONE)))));
    }
}
