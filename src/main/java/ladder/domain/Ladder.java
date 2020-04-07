package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = Collections.unmodifiableList(lines);
    }

    public static Ladder of(List<Line> lines) {
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

}
