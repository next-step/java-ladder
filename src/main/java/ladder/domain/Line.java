package ladder.domain;


import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(PointsStrategy pointsStrategy) {
        this.points = pointsStrategy.points();
    }

    public int numberOfPoints() {
        return points.size();
    }

    public boolean hasRightLine(int point) {
        return points.get(point);
    }
}
