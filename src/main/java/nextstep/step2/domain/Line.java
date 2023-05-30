package nextstep.step2.domain;

import nextstep.step2.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private List<Point> points = new ArrayList<>();

    public Line(int countOfParticipant, BooleanGenerator generator) {
        IntStream.range(0, countOfParticipant - 1)
                .forEach(i -> this.add(i, generator.generator()));

        validate(points);
    }

    public Line(Boolean... booleans) {
        this(Arrays.stream(booleans)
                .map(Point::new)
                .collect(Collectors.toList())
        );
    }

    public Line(List<Point> points) {
        validate(points);

        this.points = points;
    }

    private void validate(List<Point> points) {
        if (existConsecutiveLine(points)) {
            throw new IllegalArgumentException("가로 라인이 겹치는 사다리는 생성할 수 없습니다.");
        }
    }

    private boolean existConsecutiveLine(List<Point> points) {
        return IntStream.range(1, points.size())
                .anyMatch(i -> points.get(i).exist() && points.get(i - 1).exist());
    }

    private void add(int index, boolean generator) {
        if (existPoint(index)) {
            points.add(new Point(false));
            return;
        }

        points.add(new Point(generator));
    }

    private boolean existPoint(int index) {
        if (index == 0) {
            return false;
        }

        return points.get(index - 1).exist();
    }

    public List<Point> points() {
        return points;
    }

    public int move(int current) {
        if (isLeft(current)) {
            return current + Direction.LEFT.nextPosition();
        }

        if (isRight(current)) {
            return current + Direction.RIGHT.nextPosition();
        }

        return current;
    }

    private boolean isLeft(int current) {
        return IntStream.range(0, points.size() - 1)
                .filter(i -> existLine(i, current - 1, points.get(i)))
                .findAny()
                .isPresent();
    }

    private boolean isRight(int current) {
        return IntStream.range(0, points.size() - 1)
                .filter(i -> existLine(i, current, points.get(i)))
                .findAny()
                .isPresent();
    }

    private boolean existLine(int index, int current, Point point) {
        return index == current && point.exist();
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
