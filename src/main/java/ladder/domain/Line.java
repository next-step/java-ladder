package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public Line(int playersCount) {
        this.points = init(playersCount);
    }

    private List<Point> init(int playersCount) {
        List<Point> pointsNew = new ArrayList<>();

        PointGenerator pointGenerator = new PointGenerator(pointsNew);
        Point point = pointGenerator.first();
        Point lastBodyPoint = pointGenerator.body(playersCount - 2, point);
        pointGenerator.last(lastBodyPoint);

        return pointsNew;
    }

    public int move(int positionIndex) {
        return points.get(positionIndex).move();
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
