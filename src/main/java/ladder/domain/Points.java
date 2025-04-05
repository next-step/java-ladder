package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        this.points = points;
        validate();
    }

    public Points(int size, ConnectStrategy connectStrategy) {
        this(IntStream.range(0, size)
                .mapToObj(i -> new Point(connectStrategy, i))
                .collect(Collectors.toList()));
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
        return points.get(idx).rightConnected() && points.get(idx+1).rightConnected();
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
