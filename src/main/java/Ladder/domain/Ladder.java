package Ladder.domain;

import java.util.List;

public class Ladder {
    final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(final List<Line> lines) {
        return new Ladder(lines);
    }

    public int getHeight() {
        return this.lines.size();
    }

    public Line getLine(final int index) {
        return this.lines.get(index);
    }
}
