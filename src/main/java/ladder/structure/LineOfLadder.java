package ladder.structure;

import ladder.structure.connection.Connection;
import ladder.structure.connection.ConnectionStrategy;
import ladder.structure.connection.result.Points;

import java.util.Collections;
import java.util.List;

public class LineOfLadder {
    private static final int DIFF_OF_PARTICIPANTS_COUNT_TO_WIDTH = 1;
    private final Points points;

    public LineOfLadder(int participantsSize, ConnectionStrategy connectionStrategy) {
        int width = calculateWidth(participantsSize);
        this.points = new Points(width, connectionStrategy);
    }

    public LineOfLadder(Points movePoints) {
        this.points = movePoints;
    }

    private int calculateWidth(int participantsSize) {
        return participantsSize - DIFF_OF_PARTICIPANTS_COUNT_TO_WIDTH;
    }

    public List<Connection> getConnections() {
        return Collections.unmodifiableList(points.getConnections());
    }

    public LineOfLadder getNext(ConnectionStrategy connectionStrategy) {
        return new LineOfLadder(points.getNext(connectionStrategy));
    }

    public Points getPoints() {
        return points;
    }
}


