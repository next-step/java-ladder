package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<HorizontalLine> horizontalLines;

    public Ladder(List<HorizontalLine> horizontalLines) {
        this.horizontalLines = horizontalLines;
    }

    public List<HorizontalLine> horizontalLines() {
        return Collections.unmodifiableList(horizontalLines);
    }

    public int climb(int position) {
        for (HorizontalLine line : horizontalLines) {
            position = line.move(position);
        }
        return position;
    }
}
