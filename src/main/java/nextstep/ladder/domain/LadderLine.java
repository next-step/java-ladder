package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine generateLadderLines(int countOfPerson, MovementGenerator movementGenerator) {
        List<Point> points = new ArrayList<>();
        Point point = generateFirstPoint(points, movementGenerator);
        point = generateMiddlePoints(points, movementGenerator, countOfPerson, point);
        points = generateLastPoint(points, point);
        return new LadderLine(points);
    }

    public int move(int lineIndex) {
        return this.points.get(lineIndex).move();
    }

    public List<Point> getPoints() {
        return this.points;
    }

    private static Point generateFirstPoint(List<Point> points, MovementGenerator movementGenerator) {
        Point point = Point.firstPoint(movementGenerator);
        points.add(point);
        return point;
    }

    private static Point generateMiddlePoints(List<Point> points, MovementGenerator movementGenerator, int countOfPerson, Point point) {
        for (int i = 1; i < countOfPerson -1; i++) {
            point = point.next(movementGenerator);
            points.add(point);
        }
        return point;
    }

    private static List<Point> generateLastPoint(List<Point> points, Point point) {
        points.add(Point.lastPoint(point));
        return points;
    }
}
