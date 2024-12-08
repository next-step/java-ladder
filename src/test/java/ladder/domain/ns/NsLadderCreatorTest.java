package ladder.domain.ns;

import ladder.domain.engine.Ladder;
import ladder.domain.engine.Line;
import ladder.domain.engine.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.ns.NsLinesCreatorTest.POBI_HONUX_CRONG_JK;

public class NsLadderCreatorTest {
    @Test
    void create() {
        NsLineCreator nsLineCreator = new NsLineCreator();
        NsLinesCreator nsLinesCreator = new NsLinesCreator(nsLineCreator);
        NsLadderCreator nsLadderCreator = new NsLadderCreator(nsLinesCreator);

        int verticalSize = 5;

        Ladder ladder = nsLadderCreator.create(new Players(POBI_HONUX_CRONG_JK), verticalSize);
        List<Line> lines = ladder.getLines()
                .getLines();
        int actual = lines.size();

        Assertions.assertThat(actual).isEqualTo(verticalSize);
    }
}
