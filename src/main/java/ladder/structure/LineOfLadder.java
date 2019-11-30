package ladder.structure;

import ladder.structure.connection.MoveStrategy;
import ladder.structure.connection.result.Point;
import ladder.structure.connection.result.Points;

import java.util.Collections;
import java.util.List;

public class LineOfLadder {
    private final Points points;

    public LineOfLadder(int participantsSize, MoveStrategy moveStrategy) {
        this.points = new Points(participantsSize, moveStrategy);
    }

    public List<Integer> getNext(List<Integer> now) {
        return points.getNext(now);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points.getPoints());
    }
}


