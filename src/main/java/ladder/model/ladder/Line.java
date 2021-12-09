package ladder.model.ladder;

import ladder.model.point.Point;
import ladder.model.point.Points;
import ladder.model.util.RandomBoolean;

import java.util.*;

public class Line {

    private final Points points;

    public Line(int countOfPlayer) {
        this.points = initPoints(countOfPlayer);
    }

    public Points points() {
        return points;
    }

    public int move(int index) {
        return this.points.move(index);
    }

    private Points initPoints(int countOfPerson) {
        List<Point> points = new ArrayList<Point>();
        Point current = initFirst(points);
        current = initBody(countOfPerson, points, current);
        initLast(points, current);
        return new Points(points);
    }

    private Point initFirst(List<Point> points) {
        Point first = Point.first(RandomBoolean.get());
        points.add(first);
        return first;
    }

    private Point initBody(int countOfPerson, List<Point> points, Point current) {
        for(int idx = 1; idx < countOfPerson - 1; idx++) {
            current = current.next();
            points.add(current);
        }
        return current.next();
    }

    private void initLast(List<Point> points, Point current) {
        current = current.last();
        points.add(current);
    }
}
