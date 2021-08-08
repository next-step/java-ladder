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

    public int nextPosition(int position) {
        return position + move(position);
    }

    private int move(int position) {
        if (pointOnTheLeft(position)) {
            return -1;
        }
        if (pointOnTheRight(position)) {
            return 1;
        }
        return 0;
    }

    private boolean pointOnTheLeft(int position) {
        return position > 0 && points.get(position - 1).value();
    }

    private boolean pointOnTheRight(int position) {
        return position < points.size() && points.get(position).value();
    }

    @Override
    public Iterator<Point> iterator() {
        return points.iterator();
    }
}
