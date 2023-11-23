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

        Point basePoint = Point.createFirstPoint(pointBuildStrategy);
        points.add(basePoint);

        for (int i = 1; i < totalPointCount; i++) {
            Point nextPoint = Point.createNextPoint(basePoint.canDraw(), pointBuildStrategy);
            points.add(nextPoint);
            basePoint = nextPoint;
        }

        points.add(basePoint.createLastPoint());
        return new Line(points);
    }

    public Direction move(int startPosition) {
        Point currentPoint = this.points.get(startPosition);
        return currentPoint.move();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int pointSize() {
        return this.points.size();
    }
}
