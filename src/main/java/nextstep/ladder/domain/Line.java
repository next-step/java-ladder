package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
