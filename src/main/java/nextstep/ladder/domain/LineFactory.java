package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineFactory {

    public static Line createLine(int numberOfParticipants, int height) {
        List<Point> points = new ArrayList<>();

        Point firstPoint = Point.first();
        points.add(firstPoint);

        boolean previousRight = firstPoint.right();
        for (int i = 1; i < numberOfParticipants - 1; i++) {
            Point currentPoint = Point.middle(previousRight);
            points.add(currentPoint);
            previousRight = currentPoint.right();
        }

        Point lastPoint = Point.last(previousRight);
        points.add(lastPoint);

        return Line.of(Collections.unmodifiableList(points));
    }

}
