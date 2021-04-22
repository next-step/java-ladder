package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int MIDDLE_FIRST_INDEX = 1;

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(int countOfPerson, BooleanGenerator booleanGenerator) {
        validateLine(countOfPerson);
        return createPoints(countOfPerson, booleanGenerator);
    }

    private static Line createPoints(int countOfPerson, BooleanGenerator booleanGenerator) {
        List<Point> newPoints = new ArrayList<>();
        Point point = createFirstPoint(booleanGenerator, newPoints);
        createMiddlePoint(countOfPerson, booleanGenerator, newPoints, point);
        createLastPoint(newPoints);
        return new Line(newPoints);
    }

    private static void validateLine(int countOfPerson) {
        if (countOfPerson < 2) {
            throw new IllegalArgumentException(Members.MEMBERS_MIN_SIZE_TWO_EXCEPTION_MESSAGE);
        }
    }

    private static Point createFirstPoint(BooleanGenerator booleanGenerator, List<Point> points) {
        Point point = Point.first(booleanGenerator);
        points.add(point);
        return point;
    }

    private static void createMiddlePoint(int countOfPerson, BooleanGenerator booleanGenerator, List<Point> points, Point point) {
        for (int i = MIDDLE_FIRST_INDEX; i < countOfPerson - 1; i++) {
            point = point.middle(booleanGenerator);
            points.add(point);
        }
    }

    private static void createLastPoint(List<Point> points) {
        points.add(points.get(points.size() - 1).last());
    }

    public List<Point> getLine() {
        return points;
    }

    public int getLineSize() {
        return points.size();
    }

    public int move(int index) {
        return points.get(index).move();
    }
}
