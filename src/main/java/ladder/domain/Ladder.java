package ladder.domain;

import java.util.List;

public class Ladder {

    private final List<HorizontalLine> horizontalLines;

    public Ladder(List<HorizontalLine> horizontalLines) {
        this.horizontalLines = horizontalLines;
    }

    public List<HorizontalLine> horizontalLines() {
        return horizontalLines;
    }
}
