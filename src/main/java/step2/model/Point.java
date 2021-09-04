package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Point {
    private final boolean left;
    private final boolean current;

    public Point(boolean left, boolean current) {
        this.left = left;
        this.current = current;
    }

    public boolean getLeft() {
        return left;
    }

    public boolean getCurrent() {
        return current;
    }

    public static Point last(List<Point> pointList) {
        boolean left = pointList.get(pointList.size() - 1).current;
        return new Point(left, false);
    }

    public static List<Point> generatePoints(int numberOfPoint, ValueStrategy valueStrategy) {
        List<Point> pointList = new ArrayList<>();

        pointList.add(first(valueStrategy));
        middle(pointList, numberOfPoint, valueStrategy);
        pointList.add(last(pointList));

        return pointList;
    }

    public static Point first(ValueStrategy valueStrategy) {
        return new Point(false, valueStrategy.generateValue());
    }

    public static void middle(List<Point> pointList, int numberOfPoint, ValueStrategy valueStrategy) {
        for (int i = 1; i < numberOfPoint - 1; i++) {
            boolean left = pointList.get(i-1).getCurrent();
            boolean current = generateCurrentValue(valueStrategy, left);
            pointList.add(new Point(left, current));
        }
    }

    private static boolean generateCurrentValue(ValueStrategy valueStrategy, boolean left) {
        boolean current = valueStrategy.generateValue();

        if (left) {
            current = false;
        }

        return current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return left == point.left && current == point.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }
}
