package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = valid(points);
    }

    public static Line of(List<Boolean> points) {
        return new Line(points);
    }

    public static Line of(int countOfPerson) {
        return of(LineRandom.of(new Random()).randomList(countOfPerson - 1));
    }

    public List<Boolean> points() {
        return List.copyOf(points);
    }

    public int length() {
        return points().size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    private List<Boolean> valid(List<Boolean> points) {
        if (isNullOrEmpty(points)) {
            throw new IllegalArgumentException("라인은 빈 값일 수 없습니다.");
        }
        if (hasOverlapping(points)) {
            throw new IllegalArgumentException("겹치는 가로라인이 존재합니다.");
        }
        return points;
    }

    private boolean isNullOrEmpty(List<Boolean> points) {
        return points == null || points.isEmpty();
    }

    private boolean hasOverlapping(List<Boolean> points) {
        return IntStream.range(1, points.size())
            .anyMatch(i -> isOverlapping(points.get(i - 1), points.get(i)));
    }

    private boolean isOverlapping(Boolean a, Boolean b) {
        return a.equals(Boolean.TRUE) && b.equals(Boolean.TRUE);
    }

}
