package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LadderLine {
    private static final RandomGenerator RANDOM_GENERATOR = new RandomGenerator();

    private final List<LadderPoint> points;

    private LadderLine(List<LadderPoint> points) {
        this.points = new ArrayList<>(points);
    }

    public static LadderLine init(int userSize) {
        List<LadderPoint> points = new ArrayList<>(userSize);
        LadderPoint firstPoint = firstPoint();
        points.add(firstPoint);
        points.add(lastPoint(middlePoint(userSize, points, firstPoint)));
        return new LadderLine(points);
    }

    private static LadderPoint firstPoint() {
        return LadderPoint.first(RANDOM_GENERATOR.trueOrFalse());
    }

    private static LadderPoint middlePoint(int userSize, List<LadderPoint> points, LadderPoint point) {
        for (int i = 1; i < userSize - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static LadderPoint lastPoint(LadderPoint point) {
        return point.last();
    }

    public List<LadderPoint> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
