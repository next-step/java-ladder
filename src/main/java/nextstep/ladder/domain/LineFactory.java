package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineFactory {

    public static Line of(int pointSize) {
        List<Point> points = new ArrayList<>();

        Point point = Point.first();
        points.add(point);

        for (int i = 1; i < pointSize - 1; i++) {
            Point nextPoint = Point.next(point.current());
            points.add(nextPoint);
            point = nextPoint;
        }

        point = Point.last(point.current());
        points.add(point);

        return Line.of(Collections.unmodifiableList(points));
    }

    public static Line of(List<Boolean> rightPoints) {
        List<Point> points = new ArrayList<>();

        Point point = Point.first(rightPoints.get(0));
        points.add(point);

        for (int i = 1; i < rightPoints.size() - 1; i++) {
            Point nextPoint = Point.next(point.current(), rightPoints.get(i));
            points.add(nextPoint);
            point = nextPoint;
        }

        point = Point.last(point.current());
        points.add(point);

        return Line.of(Collections.unmodifiableList(points));
    }

}
