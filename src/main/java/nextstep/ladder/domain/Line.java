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
        if (pointIndex == points.size() - 1) {
            return MoveStrategy.create(getPointsIndex(pointIndex), false);
        }
        return MoveStrategy.create(getPointsIndex(pointIndex), getPointsIndex(pointIndex + 1));
    }
}
