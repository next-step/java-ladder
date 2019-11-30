package ladder.structure;

import ladder.structure.connection.MoveStrategy;

import java.util.List;

public class Ladder {
    private final Lines lines;

    public Ladder(int participantsSize, int ladderHeight, MoveStrategy moveStrategy) {
        this.lines = new Lines(participantsSize, ladderHeight, moveStrategy);
    }

    public List<Integer> getFinalPoints() {
        return lines.getFinalPoints();
    }

    public Lines getLines() {
        return lines;
    }
}
