package ladder.domain;

import java.util.List;

public class Ladder {
    private final List<LadderLine> lines;

    public Ladder(final List<LadderLine> lines) {
        this.lines = lines;
    }

    public List<LadderLine> getLines() {
        return lines;
    }

    public int move(int location) {
        for (LadderLine line : lines) {
            location = line.move(location);
        }
        return location;
    }
}
