package ladder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LadderGame {
    private List<Line> ladder;

    public LadderGame(List<String> asList, int i) {
        ladder = generateLadder();
    }

    public List<Line> generateLadder() {
        return Arrays.asList(
                new Line(4),
                new Line(4),
                new Line(4),
                new Line(4),
                new Line(4)
        );
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
