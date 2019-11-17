package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Points implements ImmutableList<Point> {

    private List<Point> points;

    public Points(int count) {
        points = createPoints(count);
    }

    private List<Point> createPoints(int count) {
        List<Point> totalPoints = new ArrayList<>();

        Point currentPoint = Point.createFirst();
        totalPoints.add(currentPoint);

        for (int i = 0; i < count - 2; i++) {
            currentPoint = currentPoint.createNext();
            totalPoints.add(currentPoint);
        }

        totalPoints.add(currentPoint.createLast());

        return totalPoints;
    }

    @Override
    public List<Point> get() {
        return Collections.unmodifiableList(points);
    }
}
