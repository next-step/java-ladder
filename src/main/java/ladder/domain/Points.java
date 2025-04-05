package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Points {
    private final List<Boolean> points;

    public Points(List<Boolean> points) {
        this.points = points;
        validate();
    }

    public Points(int size, ConnectStrategy connectStrategy) {
        this.points = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            points.add(connectStrategy.connect(i));
        }
        validate();
    }

    public void validate() {
        IntStream.range(0, points.size()-1)
                .filter(i -> points.get(i) && points.get(i+1))
                .findFirst()
                .ifPresent(i -> {
                    throw new IllegalArgumentException("각 포인트는 연속적으로 연결될 수 없음");
                });
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
