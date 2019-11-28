package ladder.structure;

import ladder.structure.connection.ConnectionStrategy;
import ladder.structure.connection.result.Points;

public class Ladder {
    private final Lines lines;

    public Ladder(int personCount, int ladderHeight, ConnectionStrategy connectionStrategy) {
        this.lines = new Lines(personCount, ladderHeight, connectionStrategy);
    }

    public LineOfLadder getLine(int index) {
        return this.lines.getByIndex(index);
    }

    public Points getFinalPoints() {
        return this.lines.getFinalPoints();
    }

    public Lines getLines() {
        return lines;
    }
}
