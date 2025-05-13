package nextstep.ladder2.domain.ladder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private List<Point> points;

    public Line(int size) {
        this(LineFactory.create(size, GenerateStrategy.randomBooleanSupplier));
    }

    public Line(Line line) {
        this(line.values());
    }
    public Line(Point ...points) {
        this(List.of(points));
    }

    public Line(List<Point> points) {
        this.points = points;
    }

    public int size() {
        return this.points.size();
    }

    public List<Point> values() {
        return List.copyOf(points);
    }

    public Direction move(int position) {
        return points.get(position).move();
    }

    @Override
    public String toString() {
        return IntStream.range(0, points.size() - 1)
                .mapToObj(i -> points.get(i).current() ? "|-----" : "|     ")
                .collect(Collectors.joining()) + "|";
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