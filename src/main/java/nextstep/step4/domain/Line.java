package nextstep.step4.domain;

import nextstep.step4.factory.LineFactory;

import java.util.List;

import static java.util.Collections.*;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line from(int countOfPlayer) {
        LineFactory lineFactory = new LineFactory();
        return new Line(lineFactory.create(countOfPlayer));
    }

    public static Line from(List<Point> points) {
        return new Line(points);
    }

    public int move(int column) {
        return points.get(column).move();
    }

    public List<Point> getPoints() {
        return unmodifiableList(points);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
