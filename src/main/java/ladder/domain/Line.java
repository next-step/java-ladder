package ladder.domain;


import java.util.List;

public class Line {
    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line of(PointsStrategy pointsStrategy) {
        return new Line(pointsStrategy.points());
    }

    public int numberOfPoints() {
        return points.size();
    }

    public boolean hasRightLine(int point) {
        return points.get(point);
    }
}
