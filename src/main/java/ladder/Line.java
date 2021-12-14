package ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BooleanSupplier;

public class Line {
    private static int EXCLUDE_COUNT_FIRST_AND_LAST_POINT = 2;
    private final List<Point> points;

    public Line(int width) {
        this(generatePoint(width, new RandomStrategy()));
    }

    public Line(int width, BooleanSupplier createFactor) {
        this(generatePoint(width, createFactor));
    }

    public Line(List<Point> points) {
        this.points = points;
    }

    private static List<Point> generatePoint(int width, BooleanSupplier createFactor) {
        List<Point> points = initialPoints(createFactor);

        for (int i = 0; i < width - EXCLUDE_COUNT_FIRST_AND_LAST_POINT; i++) {
            Point prevPoint = points.get(i);
            boolean random = createFactor.getAsBoolean();

            Point point = prevPoint.next(nextCurr(prevPoint, random));
            points.add(point);
        }

        envelopPoints(points);

        return points;
    }

    private static ArrayList<Point> initialPoints(BooleanSupplier createFactor) {
        Point first = Point.first(createFactor.getAsBoolean());
        return new ArrayList<>(Arrays.asList(first));
    }

    /**
     * true, true > false
     * true, false > false
     * false, true > true
     * false, false > false
     */
    private static boolean nextCurr(Point point, boolean random) {
        return !point.isCurr() & random;
    }

    private static void envelopPoints(List<Point> points) {
        points.add(points.get(points.size() - 1).next(false));
    }

    public int move(int currIndex) {
        Point currPoint = points.get(currIndex);
        Direction move = currPoint.move();

        return currIndex + move.getValue();
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
