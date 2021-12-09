package step4.domain;

import step4.strategy.PointCreateStrategy;

import java.util.List;
import java.util.Objects;

public class LadderLine {
    private final List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine of(Width width, PointCreateStrategy createStrategy) {
        return new LadderLine(createStrategy.create(width.width()));
    }

    public static LadderLine of(int width, PointCreateStrategy createStrategy) {
        return new LadderLine(createStrategy.create(width));
    }

    public Position move(Position position) {
        return pointBy(position.position()).move();
    }

    public List<Point> points() {
        return points;
    }

    public int size() {
        return points.size();
    }

    private Point pointBy(int position) {
        return points.get(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
