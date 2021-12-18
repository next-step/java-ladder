package ladder.domain;

import ladder.domain.rule.PositionGenerator;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {

    private static final int BEFORE_LAST_POINT = 2;

    HorizontalLine generate(int numberOfParticipant, PositionGenerator positionGenerator) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(positionGenerator);
        points.add(point);

        for (int i = 0; i < numberOfParticipant - BEFORE_LAST_POINT; i++) {
            point = point.next(positionGenerator);
            points.add(point);
        }
        points.add(point.last());

        return new HorizontalLine(points);
    }
}
