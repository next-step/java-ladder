package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LadderLine {
    private static final int MIN_USER_SIZE = 2;

    private static final RandomGenerator RANDOM_GENERATOR = new RandomGenerator();

    private final List<LadderPoint> points;

    private LadderLine(List<LadderPoint> points) {
        this.points = new ArrayList<>(points);
    }

    public static LadderLine init(int userSize) {
        validate(userSize);
        List<LadderPoint> points = new ArrayList<>(userSize);
        LadderPoint firstPoint = firstPoint();
        points.add(firstPoint);
        points.add(lastPoint(middlePoint(userSize, points, firstPoint)));
        return new LadderLine(points);
    }

    private static void validate(int userSize) {
        if (userSize < MIN_USER_SIZE) {
            throw new IllegalArgumentException(String.format("입력된 사용자의 수(%d)는 %d을 넘어야합니다.", userSize, MIN_USER_SIZE));
        }
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

    public int move(int position) {
        return points.get(position).move();
    }
}
