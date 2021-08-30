package ladder.model;

import java.util.Collections;
import java.util.List;

public abstract class LadderLinesGenerator {
    protected static final int FIRST_INDEX = 0;

    public abstract List<LadderLine> generate(int ladderHeight, int pointCount);

    protected List<LadderLine> shuffled(List<LadderLine> lines) {
        Collections.shuffle(lines);
        return lines;
    }
}
