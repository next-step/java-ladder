package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Points {

    private final List<Point> points;

    public Points(List<Point> points) {
        this.points = points;
    }

    public Points(int count) {
        this(createPoints(count));
    }

    public int move(int startPosition) {
        return points.get(startPosition).move();
    }

    private static List<Point> createPoints(int count) {
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

    public List<Point> getValue() {
        return Collections.unmodifiableList(points);
    }
}
