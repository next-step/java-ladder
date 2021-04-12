package nextstep.refactoring.ladder.concrete;

import java.util.ArrayList;
import java.util.List;
import nextstep.refactoring.ladder.engine.Line;
import nextstep.refactoring.ladder.engine.LineCreator;

public class LineCreatorImpl implements LineCreator {

    @Override
    public Line create(int numberOfPoints) {
        List<Point> points = new ArrayList<>();

        Point point = Point.first();
        points.add(point);

        for (int i = 0; i < numberOfPoints - 1; i++) {
            point = point.next();
            points.add(point);
        }

        points.add(point.last());

        return new LadderLine(points);
    }

}
