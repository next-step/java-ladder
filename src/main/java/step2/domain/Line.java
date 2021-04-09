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
        sameLineValidation(points);
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

    public void sameLineValidation(List<Point> points) {
        if (points.size() > 1) {
            validateList(points);
        }
    }

    private void validateList(List<Point> points) {
        for (int i = 1; i < points.size(); i++) {
            compare(points, i);
        }
    }

    private void compare(List<Point> points, int index) {
        if (points.get(index -1).equals(points.get(index))) {
            throw new IllegalArgumentException("같은 라인에는 연속적으로 라인이 생성될 수 없습니다.");
        }
    }

    public List<Point> getPoints() {
        sameLineValidation(points);
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
