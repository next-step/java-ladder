package ladder.domain;

import ladder.stretagy.PointBuildStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line createLine(int joinMembersCount, PointBuildStrategy pointBuildStrategy) {
        int totalPointCount = joinMembersCount - 1;
        List<Point> points = new ArrayList<>();

        Point basePoint = new Point(pointBuildStrategy.build());
        points.add(basePoint);

        for (int i = 1; i < totalPointCount; i++) {
            Point nextPoint = basePoint.nextPoint(pointBuildStrategy);
            points.add(nextPoint);
            basePoint = nextPoint;
        }
        return new Line(points);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public boolean canMoveRight(int index) {
        return isMovable(index);
    }

    public boolean canMoveLeft(int index) {
        return isMovable(index - 1);
    }

    private boolean isMovable(int index) {
        try {
            Point currentPoint = this.points.get(index);
            return currentPoint.canDraw();
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
}
