package ladder.domain;

import ladder.stretagy.PointBuildStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Point> points = new ArrayList<>();

    public Line(int joinMembersCount, PointBuildStrategy pointBuildStrategy) {
        int totalPointCount = joinMembersCount - 1;

        Point basePoint = new Point(pointBuildStrategy.build());
        this.points.add(basePoint);

        for (int i = 1; i < totalPointCount; i++) {
            Point nextPoint = basePoint.nextPoint(pointBuildStrategy);
            this.points.add(nextPoint);
            basePoint = nextPoint;
        }
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
