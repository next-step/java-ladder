package ladder.engine.impl;

import ladder.engine.Line;

import java.util.ArrayList;
import java.util.List;

import static ladder.engine.utils.RandomValueGenerator.generate;

public class LineFactory {
    public static Line createLine(final int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(generate());
        points.add(point);
        while(!point.isLast(sizeOfPerson)) {
            point = point.next();
            points.add(point);
        }
        return new DefaultLine(points);
    }
}
