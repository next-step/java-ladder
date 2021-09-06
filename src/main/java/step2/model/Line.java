package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {
    private List<Point> points;

    public Line(int numberOfUser, ValueStrategy valueStrategy) {
        generatePoint(numberOfUser, valueStrategy);
    }

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Boolean> getLine() {
        return points.stream()
                        .map(Point::getCurrent)
                        .collect(Collectors.toList());
    }

    public int changeIndex(int index) {
        return points.get(index).changeIndex(index);
    }

    private void generatePoint(int numberOfPoint, ValueStrategy valueStrategy) {
        points = new ArrayList<>();

        points.add(first(valueStrategy));
        middle(points, numberOfPoint, valueStrategy);
        points.add(last(getLastPoint(points)));
    }

    private Point first(ValueStrategy valueStrategy) {
        return new Point(false, valueStrategy.generateValue());
    }

    private void middle(List<Point> points, int numberOfPoint, ValueStrategy valueStrategy) {
        for (int i = 1; i < numberOfPoint - 1; i++) {
            points.add(next(getLastPoint(points), valueStrategy));
        }
    }

    private Point next(Point lastPoint, ValueStrategy valueStrategy) {
        boolean current = valueStrategy.generateValue();

        if (lastPoint.getCurrent()) {
            current = false;
        }

        return new Point(lastPoint.getCurrent(), current);
    }

    private Point last(Point lastPoint) {
        return new Point(lastPoint.getCurrent(), false);
    }

    private Point getLastPoint(List<Point> points) {
        return points.get(points.size() - 1);
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
