package nextstep.mission;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        validate(points);
        this.points = points;
    }

    public Line(int size) {
        this(createPoints(size));
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public static List<Boolean> createPoints(int size) {
        List<Boolean> result = new ArrayList<>();
        result.add(false);

        result.addAll(IntStream.range(0, size - 1)
                .mapToObj((value) -> new Random().nextBoolean())
                .collect(Collectors.toList()));

        IntStream.range(0, result.size() - 1)
                .forEach(index -> {
                    if (result.get(index) == true && result.get(index + 1) == true)
                        result.set(index, false);
                });


        return result;
    }

    private void validate(List<Boolean> points) {
        IntStream.range(0, points.size() - 1)
                .forEach(index -> validPoint(points.get(index), points.get(index + 1)));
    }

    private void validPoint(Boolean point1, Boolean point2) {
        if (point1 == true && point2 == true)
            throw new IllegalArgumentException("선은 겹칠수 없습니다.");
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

    @Override
    public String toString() {
        return Arrays.toString(points.toArray());
    }
}
