package ladder.model.point;

import java.util.*;

public class Points {

    private final List<Point> points = new ArrayList<Point>();;

    public Points(int countOfPerson) {
        Point current = Point.first();
        for(int idx = 0; idx < countOfPerson; idx++) {
            points.add(current);
            current = current.next();
        }
    }

    public List<Point> get() {
        return Collections.unmodifiableList(points);
    }
}
