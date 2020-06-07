package ladder.domain;

import java.util.List;

public class Ladder {
    private final List<Line> lineList;

    public Ladder(final List<Line> lineList) {
        this.lineList = lineList;
    }

    public List<Line> getLineList() {
        return lineList;
    }
}
