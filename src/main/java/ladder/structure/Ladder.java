package ladder.structure;

import ladder.structure.connection.ConnectionStrategy;
import ladder.structure.connection.result.Points;

public class Ladder {
    private final Lines lines;
    private final ConnectionStrategy connectionStrategy;

    public Ladder(int participantsSize, int ladderHeight, ConnectionStrategy connectionStrategy) {
        this.lines = new Lines(participantsSize, ladderHeight, connectionStrategy);
        this.connectionStrategy = connectionStrategy;
    }

    public Points getFinalPoints() {
        return this.lines.getFinalPoints(connectionStrategy);
    }

    public Lines getLines() {
        return lines;
    }
}
