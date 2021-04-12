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

    public static Line from(int countOfPerson, BooleanStrategy booleanStrategy) {
        List<Point> points = new ArrayList<>();
        points.add(Point.from(booleanStrategy));
        IntStream.range(0, countOfPerson - 2)
            .forEach(i -> points.add(points.get(i).nextPoint()));
        return new Line(points);
    }

    public static Line from(List<Point> points) {
        return new Line(points);
    }

    @Override
    public Iterator<Point> iterator() {
        return points.iterator();
    }
}
