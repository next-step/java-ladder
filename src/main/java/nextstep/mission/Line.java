package nextstep.mission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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

    private static List<Boolean> createPoints(int size) {
        List<Boolean> result = new ArrayList<>(Arrays.asList(false));
        RandomPoint randomPoint = new RandomPoint(false);

        result.addAll(IntStream.range(1, size)
                .mapToObj((value) -> randomPoint.next())
                .collect(Collectors.toList()));
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

    public boolean checkSize(int size) {
        return this.points.size() == size;
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