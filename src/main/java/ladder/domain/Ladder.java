package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Ladder (DirectionStrategy directionStrategy, int ladderHeight, int userCount) {
        lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(directionStrategy, userCount));
        }
    }
    public List<Line> getLines() {
        return lines;
    }
}
