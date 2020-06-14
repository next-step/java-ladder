package ladder.domain;

import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int move(int location) {
        for (Line line : lines) {
            location = line.move(location);
        }
        return location;
    }
}
