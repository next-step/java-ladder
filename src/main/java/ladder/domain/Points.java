package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Points {

    private final List<Integer> points;

    public Points(int memberCount) {
        this(IntStream.range(0, memberCount)
                .boxed()
                .collect(Collectors.toList()));
    }

    public Points(List<Integer> points) {
        this.points = points;
    }

    public Points move(Line line) {
        return new Points(points.stream()
                .map(line::move)
                .collect(Collectors.toList()));
    }

    public int getSize() {
        return points.size();
    }

    public int get(int index) {
        if (index < 0 || index >= points.size()) {
            throw new IllegalArgumentException("객체 범위 외의 인덱스는 허용하지 않습니다.");
        }
        return points.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Points points1 = (Points) o;
        return Objects.equals(points, points1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
