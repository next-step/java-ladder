package ladder;

import java.util.ArrayList;
import java.util.List;

public class LineFactory {
    public static Line createLine(ValueGenerator valueGenerator, int people) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(valueGenerator.generate());
        points.add(point);

        while(point.untilBeforeLastPoint(people)) {
            point = point.next(valueGenerator.generate());
            points.add(point);
        }

        points.add(point.last());
        return new Line(points);
    }
}
