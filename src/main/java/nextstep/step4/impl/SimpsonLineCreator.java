package nextstep.step4.impl;

import nextstep.step4.engine.Line;
import nextstep.step4.engine.LineCreator;

import java.util.ArrayList;
import java.util.List;

import static nextstep.step4.engine.RandomGenerator.generate;
import static nextstep.step4.engine.RandomGenerator.isCreate;

public class SimpsonLineCreator implements LineCreator {
    @Override
    public Line create(final int size) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(generate());
        points.add(point);

        for (int i = 0; i < size - 2; i++) {
            point = point.next(isCreate(point));
            points.add(point);
        }

        points.add(point.last());
        return new SimpsonLine(points);
    }
}
