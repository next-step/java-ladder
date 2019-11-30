package ladder.structure;

import ladder.structure.connection.MoveStrategy;
import ladder.structure.connection.result.Points;

public class LineOfLadder {
    private static final int DIFF_OF_PARTICIPANTS_COUNT_TO_WIDTH = 1;
    private final Points points;

    public LineOfLadder(int participantsSize, MoveStrategy moveStrategy) {
        int width = calculateWidth(participantsSize);
        this.points = new Points(width, moveStrategy);
    }

    private LineOfLadder(Points movePoints) {
        this.points = movePoints;
    }

    private int calculateWidth(int participantsSize) {
        return participantsSize - DIFF_OF_PARTICIPANTS_COUNT_TO_WIDTH;
    }

    public LineOfLadder getNext(MoveStrategy moveStrategy) {
        return new LineOfLadder(points.getNext(moveStrategy));
    }

    public Points getPoints() {
        return points;
    }
}


