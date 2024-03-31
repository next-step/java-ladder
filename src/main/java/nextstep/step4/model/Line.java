package nextstep.step4.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int MIN_POINT_SIZE = 2;

    private final List<Point> points;

    public Line(List<Point> points) {
        validate(points);

        this.points = points;
    }

    private void validate(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("빈 라인 정보는 허용하지 않습니다");
        }

        if (points.size() < MIN_POINT_SIZE) {
            throw new IllegalArgumentException("라인 정보는 " + MIN_POINT_SIZE + "개 이상 필요합니다");
        }
    }

    public int move(int position) {
        Point point = this.points.get(position);
        Direction direction = point.move();
        return direction.move(position);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(this.points);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Line line = (Line) other;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
