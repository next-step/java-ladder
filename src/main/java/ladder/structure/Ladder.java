package ladder.structure;

import ladder.game.Points;
import ladder.structure.connection.ConnectionStrategy;

public class Ladder {
    private final Lines lines;

    public Ladder(int personCount, int ladderHeight, ConnectionStrategy connectionStrategy) {
        this.lines = new Lines(personCount, ladderHeight, connectionStrategy);
    }

    public Points getFinalPoints() {
        return this.lines.getFinalPoints();
    }

    public Lines getLines() {
        return lines;
    }

    public LineOfLadder getLine(int index) {
        return this.lines.getByIndex(index);
    }
}
