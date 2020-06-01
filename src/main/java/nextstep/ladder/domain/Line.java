package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points;

    Line(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public int size() {
        return points.size();
    }

    public boolean getPointsIndex(int index) {
        return points.get(index).getValue();
    }

    public List<Point> getPointsValue() {
        return new ArrayList<>(this.points);
    }

    public MoveStrategy whereToMove(int pointIndex) {
        if (getPointsIndex(pointIndex)) {
            return MoveStrategy.MOVE_LEFT;
        }
        if (getPointsIndex(pointIndex + 1)) {
            return MoveStrategy.MOVE_RIGHT;
        }
        return MoveStrategy.STAY;
    }
}
