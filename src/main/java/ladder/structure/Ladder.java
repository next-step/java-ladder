package ladder.structure;

import ladder.game.Points;
import ladder.structure.connection.ConnectionStrategy;

public class Ladder {
    private final int width;
    private final Lines lines;

    public Ladder(int personCount, int ladderHeight, ConnectionStrategy connectionStrategy) {
        this.width = personCount - 1;
        this.lines = new Lines(personCount, ladderHeight, connectionStrategy);
    }

    public Points getFinalPoints() {
        return this.lines.getFinalPoints();
    }

    public LineOfLadder getLine(int index) {
        return this.lines.get(index);
    }

    public int height() {
        return this.lines.size();
    }

    public int width() {
        return this.width;
    }
}
