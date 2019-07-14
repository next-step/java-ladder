package ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points;

    public Line(int lineLength, PointMaker pointMaker) {
        this.points = this.makePoints(lineLength, pointMaker);
    }

    private List<Point> makePoints(int lineCount, PointMaker pointMaker) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(pointMaker);
        points.add(point);
        for (int i = 0; i < lineCount - 2; i++) {
            point = point.next(pointMaker);
            points.add(point);
        }
        points.add(point.last());
        return points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public int size() {
        return this.points.size();
    }

    public int move(int column) {
        return points.get(column).move();
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
