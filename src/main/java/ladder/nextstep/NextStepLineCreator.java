package ladder.nextstep;

import ladder.engine.Line;
import ladder.engine.LineCreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ladder.nextstep.utils.RandomValueGenerator.generate;

public class NextStepLineCreator implements LineCreator {
    @Override
    public Line create(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(generate());
        points.add(point);

        while(point.untilBeforeLastPoint(sizeOfPerson)) {
            point = point.next();
            points.add(point);
        }

        points.add(point.last());

        System.out.println("Points : " + points);
        return new NextStepLine(Collections.unmodifiableList(points));
    }
}
