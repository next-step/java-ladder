package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Line {

    private final List<Point> points;

    public Line(List<Point> points){
        validatePoints(points);
        this.points = points;
    }

    private void validatePoints(List<Point> points) {
        points.stream()
                .filter(point -> point.getDirection().isLeft() && point.getDirection().isRight())
                .findAny()
                .ifPresent(point -> {
                    throw new IllegalArgumentException("사다리 가로라인은 겹칠 수 없습니다.");
                });
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
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
