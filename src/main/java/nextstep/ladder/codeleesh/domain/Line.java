package nextstep.ladder.codeleesh.domain;

import java.util.*;
import java.util.stream.IntStream;

public class Line {

    private final List<Point> points;

    public Line(final List<Point> points) {
        
        validate(points);
        this.points = points;
    }

    private void validate(final List<Point> points) {

        if (isDuplicatePoint(points)) {
            throw new IllegalArgumentException("연속된 사다리는 그릴 수 없습니다.");
        }
    }

    public Map<Integer, Integer> convert() {

        final Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < this.points.size(); i++) {
            final Point point = this.points.get(i);
            result.put(i, point.move());
        }
        return result;
    }

    private static boolean isDuplicatePoint(List<Point> values) {

        return IntStream.range(1, values.size())
                .anyMatch(i -> values.get(i).duplicate());
    }

    public List<Point> getPoints() {

        return Collections.unmodifiableList(this.points);
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
