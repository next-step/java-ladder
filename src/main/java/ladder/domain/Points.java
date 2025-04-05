package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        this.points = points;
        validate();
    }

    public Points(int size, ConnectStrategy connectStrategy) {
        this(generatePoints(size, connectStrategy));
    }

    public List<Point> values() {
        return points;
    }

    private static List<Point> generatePoints(int size, ConnectStrategy connectStrategy) {
        List<Point> points = new ArrayList<>(size);
        IntStream.range(0, size)
                .forEach(i -> points.add(new Point(connectStrategy.connect(i, i != 0 && points.get(i - 1).connected()))));
        return points;
    }

    public void validate() {
        IntStream.range(0, points.size()-1)
                .filter(this::continuousConnected)
                .findFirst()
                .ifPresent(i -> {
                    throw new IllegalArgumentException("각 포인트는 연속적으로 연결될 수 없음");
                });
    }

    private boolean continuousConnected(int idx) {
        return points.get(idx).connected() && points.get(idx+1).connected();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Points points1 = (Points) o;
        return Objects.equals(points, points1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }
}
