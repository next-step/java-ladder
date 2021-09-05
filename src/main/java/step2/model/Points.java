package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        this.points = points;
    }

    public Points(int numberOfUser, ValueStrategy valueStrategy) {
        this.points = generatePoints(numberOfUser, valueStrategy);
    }

    private Point getPoint(int index) {
        return points.get(index);
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

    public static Point last(List<Point> pointList) {
        boolean left = pointList.get(pointList.size() - 1).getCurrent();
        return new Point(left, false);
    }

    public List<Boolean> getPoints() {
        return points.stream()
                .map(Point::getCurrent)
                .collect(Collectors.toList());
    }

    public int changeIndex(int index) {
        return getPoint(index).changeIndex(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points1 = (Points) o;
        return Objects.equals(points, points1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
