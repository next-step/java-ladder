package nextstep.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private List<Point> points = new ArrayList<>();

    public Line(int countOfPerson, BooleanFunction booleanFunction) {
        Point point = Point.first(booleanFunction);
        points.add(point);

        for (int i = 1; i < countOfPerson - 1; i++) {
            point = point.next(booleanFunction);
            points.add(point);
        }
        points.add(point.last());
    }

    public List<Point> getPoints() {
        return  Collections.unmodifiableList(points);
    }
}