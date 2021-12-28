package ladderinterface.concrete;

import ladderinterface.engine.Ladder;
import ladderinterface.engine.LadderResult;
import ladderinterface.engine.Line;
import ladderinterface.fixture.TestLadderFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StepLadderTest {

    @Test
    void play() {
        Ladder stepLadder = createLadder();
        assertThat(stepLadder.play()).isEqualTo(createLadderResult());
    }

    private static Ladder createLadder() {
        List<Line> lines = new ArrayList<>();
        Line line1 = TestLadderFactory.createLine(true, false, true, false);
        Line line2 = TestLadderFactory.createLine(false, true, false, false);
        Line line3 = TestLadderFactory.createLine(true, false, false, false);
        Line line4 = TestLadderFactory.createLine(false, true, false, false);
        Line line5 = TestLadderFactory.createLine(true, false, true, false);

        lines.add(line1);
        lines.add(line2);
        lines.add(line3);
        lines.add(line4);
        lines.add(line5);

        return StepLadder.of(4, lines);
    }

    private static LadderResult createLadderResult() {
        LadderResult ladderResult = new LadderResult();
        ladderResult.put(0, 0);
        ladderResult.put(1, 3);
        ladderResult.put(2, 2);
        ladderResult.put(3, 1);

        return ladderResult;
    }

}
