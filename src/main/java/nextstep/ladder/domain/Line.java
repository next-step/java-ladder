package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class Line implements Iterable<Point> {
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(int countOfPerson, BooleanStrategy booleanStrategy) {
        List<Point> points = new ArrayList<>();
        points.add(Point.of(booleanStrategy));
        IntStream.range(0, countOfPerson - 2)
            .forEach(i -> points.add(points.get(i).nextPoint(booleanStrategy)));
        return new Line(points);
    }

    public static Line of(List<Point> points) {
        return new Line(points);
    }

    @Override
    public Iterator<Point> iterator() {
        return points.iterator();
    }

    public int nextHorizontalNumber(int horizontalNumber) {
        if (pointOnTheLeft(horizontalNumber)) {
            return --horizontalNumber;
        }
        if (pointOnTheRight(horizontalNumber)) {
            return ++horizontalNumber;
        }
        return horizontalNumber;
    }

    private boolean pointOnTheLeft(int horizontalNumber) {
        return horizontalNumber > 0 && points.get(horizontalNumber - 1).value();
    }

    private boolean pointOnTheRight(int horizontalNumber) {
        return horizontalNumber < points.size() && points.get(horizontalNumber).value();
    }
}
