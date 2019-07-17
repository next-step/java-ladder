package ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points;

    public Line(int lineLength, PointMaker pointMaker) {
        this.points = new ArrayList<>();
        this.makePoints(lineLength, pointMaker);
    }

    private void makePoints(int lineCount, PointMaker pointMaker) {
        addFirstPoint(pointMaker);
        addMidPoint(lineCount, pointMaker);
        addLastPoint();
    }

    private void addLastPoint() {
        this.points.add(lastPoint().last());
    }

    private void addMidPoint(int lineCount, PointMaker pointMaker) {
        Point point = lastPoint();
        for (int i = 0; i < lineCount - 2; i++) {
            this.points.add(point.next(pointMaker));
        }
    }

    private void addFirstPoint(PointMaker pointMaker) {
        Point point = Point.first(pointMaker);
        points.add(point);
    }

    public Point lastPoint() {
        return this.points.get(points.size()-1);
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
