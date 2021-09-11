package step2.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {
    private final List<Boolean> points;

    public Line(int height) {
        this(height, new PointFalseStrategy());
    }

    public Line(int height, PointStrategy pointStrategy) {
        this.points = Stream.generate(() -> pointStrategy.create())
                .limit(height)
                .collect(Collectors.toList());
    }

    public Line(Line previousLine) {
        this(previousLine, new PointRandomStrategy());
    }

    public Line(Line previousLine, PointStrategy pointStrategy) {
        this.points = previousLine.points
                .stream()
                .map(previousPoint -> {
                    if (previousPoint) {
                        return false;
                    }
                    return pointStrategy.create();
                })
                .collect(Collectors.toList());
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "line=" + points +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
