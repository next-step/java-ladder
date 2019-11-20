package ladder.structure;

import ladder.structure.connection.ConnectionStrategy;

public class Ladder {
    private final int width;
    private final Lines lines;

    public Ladder(int personCount, int ladderHeight, ConnectionStrategy connectionStrategy) {
        this.width = personCount - 1;
        this.lines = new Lines(personCount, ladderHeight, connectionStrategy);
    }

    public int getFinalPoint(int index) {
        return this.lines.getFinalPoint(index);
    }

    public LineOfLadder getLine(int index) {
        return this.lines.getLine(index);
    }

    public int getLadderHeight() {
        return this.lines.getLadderHeight();
    }

    public int getLadderWidth() {
        return this.width;
    }
}
