package Ladder.domain;

import java.util.List;

public class Ladder {
    final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public Ladder of(final List<Line> lines) {
        return new Ladder(lines);
    }
}
