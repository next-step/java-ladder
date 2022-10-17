package nextstep.ladder.model;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    int move(int startPosition) {
        int resultPosition = startPosition;

        for (Line line : lines) {
            resultPosition = line.move(resultPosition);
        }

        return resultPosition;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
