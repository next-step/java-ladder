package ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points;

    public Line(int lineLength, PointMaker pointMaker) {
        this.makePoints(lineLength, pointMaker);
    }

    private void makePoints(int lineCount, PointMaker pointMaker) {
        addFirstPoint(pointMaker);
        addMidPoint(lineCount, pointMaker);
        addLastPoint();
    }

     void addLastPoint() {
        this.points.add(lastPoint().last());
    }

     void addMidPoint(int lineCount, PointMaker pointMaker) {
        for (int i = 0; i < lineCount - 2; i++) {
            this.points.add(lastPoint().next(pointMaker));
        }
    }

     void addFirstPoint(PointMaker pointMaker) {
        this.points = new ArrayList<>();
        this.points.add(Point.first(pointMaker));
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
