package refactoring.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyLineFactory implements LineFactory {

    @Override
    public Line create(final int countOfPlayer) {
        List<Point> points = new ArrayList<>(countOfPlayer);

        Point point = Point.first(LineStatus.generate());
        points.add(point);

        while (point.beforeLast(countOfPlayer)) {
            point = point.next();
            points.add(point);
        }

        points.add(point.last());
        return new MyLine(Collections.unmodifiableList(points));
    }

}
