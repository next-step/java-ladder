package nextstep.refactoring.ladder.concrete;

import nextstep.refactoring.ladder.engine.Line;
import nextstep.refactoring.ladder.engine.LineCreator;

import java.util.ArrayList;
import java.util.List;

public class LineCreatorImpl implements LineCreator {

    @Override
    public Line create(int numberOfPoints) {
        List<Point> points = new ArrayList<>();

        Point point = Point.first();
        points.add(point);

        for (int i = 0; i < numberOfPoints - 2; i++) {
            point = point.next();
            points.add(point);
        }

        points.add(point.last());

        return new LadderLine(points);
    }

}
