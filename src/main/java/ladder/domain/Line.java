package ladder.domain;

import java.util.*;

public class Line {

    private final Width width;

    private final List<Boolean> points;

    private Line(Width width, List<Boolean> points) {
        this.width = width;
        this.points = points;
    }

    private Line(Width width) {
        this(width, initPointsWithValueFalse(width));
    }

    private static List<Boolean> initPointsWithValueFalse(Width width) {
        final List<Boolean> points = new ArrayList<>(width.getLength());
        points.addAll(Collections.nCopies(width.getLength(), Boolean.FALSE));
        return points;
    }

    public static Line create(Boolean... values) {
        return new Line(Width.create(values.length), Arrays.asList(values));
    }

    public static Line createWithWidth(Width width) {
        return new Line(width);
    }

    public void check(int index) {
        points.set(index, Boolean.TRUE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(width, line.width) && Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, points);
    }
}
