package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {
    private static final RandomGenerator randomGenerator = new RandomGenerator();
    private List<Point> points = new ArrayList<>();
    public Line(){}

    public Line(List<Point> points) {
        this.points = points;
    }

    public Line generate(int countOfPerson) {
        return generate(countOfPerson, () -> randomGenerator.number());
    }

    public Line generate(int countOfPerson, NumberGenerator numberGenerator) {
        Line line = new Line();
        IntStream.range(0, countOfPerson)
                .mapToObj(i -> line.isPoint(i, numberGenerator))
                .forEach(line::addPoint);
        return line;
    }

    private void addPoint(Point point) {
        points.add(point);
    }

    public Point isPoint(int index, NumberGenerator numberGenerator) {
        if (index == 0 || points.get(index-1).currentPoint()) {
            return new Point(false);
        }

        return new Point(numberGenerator.number());
    }

    public List<Point> getPoints() {
        return points;
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
