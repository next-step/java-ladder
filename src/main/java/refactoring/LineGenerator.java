package refactoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import refactoring.domain.LineStatus;
import refactoring.domain.Point;

public class LineGenerator {


    public Line create(final int countOfPlayer) {
        List<Point> points = new ArrayList<>(countOfPlayer);

        Point point = Point.first(LineStatus.generate());
        points.add(point);

        while (point.beforeLast(countOfPlayer)) {
            point = point.next();
            points.add(point);
        }

        points.add(point.last());
        return new Line(Collections.unmodifiableList(points));
    }

}
