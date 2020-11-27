package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static util.Preconditions.checkArgument;

public class LadderLine {
    private static final int MINIMUM_USER_COUNT = 2;
    public static final String PERSON_COUNT_MUST_MORE_THEN_TWO = "person count must more then two";
    private final List<Point> points;

    private LadderLine(final List<Point> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public static LadderLine of(final int userCount) {
        checkArgument(userCount >= MINIMUM_USER_COUNT, PERSON_COUNT_MUST_MORE_THEN_TWO);
        final List<Point> points = new ArrayList<>(userCount);

        initFirstPoint(points);

        final int pointCountExceptFirstAndLast = userCount - 2;
        initMiddlePoints(pointCountExceptFirstAndLast, points);
        
        final Point lastBefore = points.get(points.size() - 1);
        initLastPoint(points, lastBefore);

        return new LadderLine(points);
    }

    private static void initFirstPoint(final List<Point> points) {
        final Point first = Point.createFirst();
        points.add(first);
    }

    private static void initMiddlePoints(final int count, final List<Point> points) {
        for (int i = 0; i < count; i++) {
            final Point now = points.get(i);
            final Point nextPoint = now.createNext();
            points.add(nextPoint);
        }
    }

    private static void initLastPoint(final List<Point> points, final Point lastBefore) {
        points.add(lastBefore.createLast());
    }

    public int size() {
        return points.size();
    }

    public List<Point> getPoints() {
        return points;
    }
}
