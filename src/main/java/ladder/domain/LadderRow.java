package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderRow {
    private final List<Point> points;

    public LadderRow(List<Point> points) {
        this.points = points;
    }

    public static LadderRow of(int width, DrawStrategy drawStrategy) {
        Point firstPoint = Point.first(drawStrategy.draw());
        List<Point> points = Stream.iterate(firstPoint, p -> p.next(drawStrategy))
                .limit(width - 1)
                .collect(Collectors.toList());
        points.add(points.get(width - 2).last());
        return new LadderRow(points);
    }

    public int width() {
        return points.size();
    }

    public List<Boolean> hasRightConnections() {
        return points.stream()
                .map(Point::isRight)
                .collect(Collectors.toList());
    }

    public int move(int position) {
        return points.get(position).move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderRow ladderRow = (LadderRow) o;
        return Objects.equals(points, ladderRow.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
