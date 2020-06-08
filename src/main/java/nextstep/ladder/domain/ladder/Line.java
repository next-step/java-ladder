package nextstep.ladder.domain.ladder;

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

    boolean getPointsIndex(int index) {
        return points.get(index).getValue();
    }

    public List<Point> getPoints() {
        return new ArrayList<>(this.points);
    }

    public HorizontalMoveStrategy whereToMove(int pointIndex) {
        if (pointIndex == points.size() - 1) {
            return HorizontalMoveStrategy.find(getPointsIndex(pointIndex), false);
        }
        return HorizontalMoveStrategy.find(getPointsIndex(pointIndex), getPointsIndex(pointIndex + 1));
    }
}
