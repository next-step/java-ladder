package ladder.structure;

import ladder.structure.connection.MoveStrategy;
import ladder.structure.connection.result.Points;

public class Ladder {
    private final Lines lines;
    private final MoveStrategy moveStrategy;

    public Ladder(int participantsSize, int ladderHeight, MoveStrategy moveStrategy) {
        this.lines = new Lines(participantsSize, ladderHeight, moveStrategy);
        this.moveStrategy = moveStrategy;
    }

    public Points getFinalPoints() {
        return this.lines.getFinalPoints(moveStrategy);
    }

    public Lines getLines() {
        return lines;
    }
}
