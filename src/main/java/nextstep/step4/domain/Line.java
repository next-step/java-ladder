package nextstep.step4.domain;

import nextstep.step4.util.LadderPointGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line from(int countOfPlayer) {
        List<Point> points = new ArrayList<>();

        Point currentPoint = drawFirstPoint(points);
        currentPoint = drawMiddlePoints(countOfPlayer, points, currentPoint);
        drawLastPoint(points, currentPoint);

        return new Line(points);
    }

    public int move(int column) {
        return points.get(column).move();
    }

    public static Line from(List<Point> points) {
        return new Line(points);
    }

    private static Point drawFirstPoint(List<Point> points) {
        Point firstPoint = Point.first(LadderPointGenerator.generateDirection());
        points.add(firstPoint);
        return firstPoint;
    }

    private static Point drawMiddlePoints(int countOfPlayer, List<Point> points, Point currentPoint) {
        for (int i = 1; i < countOfPlayer - 1; i++) {
            currentPoint = currentPoint.next();
            points.add(currentPoint);
        }
        return currentPoint;
    }

    private static void drawLastPoint(List<Point> points, Point currentPoint) {
        Point lastPoint = currentPoint.last();
        points.add(lastPoint);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
