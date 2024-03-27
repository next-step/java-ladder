package nextstep.ladder.model;

import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Point> points;

    public static Line from(int countOfPerson) {
        return new Line(PointsFactory.createBy(countOfPerson));
    }

    public static Line from(Point... points) {
        return new Line(List.of(points));
    }

    public Line(List<Point> points) {
        assertNullOrEmpty(points);
        this.points = points;
    }

    private void assertNullOrEmpty(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("라인 정보가 비어있습니다");
        }
    }

    public void move(Player player) {
        Point point = this.points.get(player.getPosition());
        player.moveTo(point.directionTo());
    }

    public List<Point> getPoints() {
        return points;
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
