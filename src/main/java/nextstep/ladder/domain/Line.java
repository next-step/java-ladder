package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Line implements Iterable<Point> {

    private List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line from(int countOfPerson, BooleanStrategy booleanStrategy) {
        List<Point> points = new ArrayList<>();
        points.add(Point.from(booleanStrategy));
        for (int i = 0; i < countOfPerson - 2; i++) {
            points.add(points.get(i).nextPoint());
        }
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
