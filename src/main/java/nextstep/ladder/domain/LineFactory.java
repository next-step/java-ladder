package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineFactory {

    public static Line createLine(int numberOfParticipants, int height) {
        List<Point> points = new ArrayList<>();

        Point firstPoint = Point.first();
        points.add(firstPoint);

        boolean previousLeft = firstPoint.left();
        for (int i = 1; i < numberOfParticipants - 1; i++) {
            Point currentPoint = Point.middle(previousLeft);
            points.add(currentPoint);
            previousLeft = currentPoint.left();
        }

        Point lastPoint = Point.last(previousLeft);
        points.add(lastPoint);

        return Line.of(Collections.unmodifiableList(points));
    }

}
