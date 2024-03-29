package nextstep.step4.model;

import nextstep.step4.api.Line;

import java.util.List;
import java.util.Objects;

public class SimpleLine implements Line {
    private final List<Point> points;

    public SimpleLine(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("빈 라인 정보는 허용하지 않습니다");
        }
        
        this.points = points;
    }

    @Override
    public int move(int position) {
        Point point = this.points.get(position);
        Direction direction = point.move();
        return direction.move(position);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        SimpleLine line = (SimpleLine) other;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
