package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private final int heightOfLadder;

    public Ladder(List<Line> lines, int heightOfLadder) {
        this.lines = Collections.unmodifiableList(lines);
        this.heightOfLadder = heightOfLadder;
    }

    public int getHeightOfLadder() {
        return heightOfLadder;
    }

    public List<Line> getLines() {
        return lines;
    }
}
