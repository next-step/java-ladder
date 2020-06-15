package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {

    public static Ladder createLadder(final int personCount, final int ladderHeight) {
        List<LadderLine> lines = new ArrayList<>();
        for (int idx = 0; idx < ladderHeight; idx++) {
            LadderLine line = LadderLine.init(personCount);
            lines.add(line);
        }
        return new Ladder(lines);
    }
}
