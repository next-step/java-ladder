package ladder.domain.v2;

import ladder.domain.Position;
import ladder.domain.factory.ILine;
import ladder.external.RandomFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class LadderLine implements ILine {
    private final List<Point> points;

    LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine init(int playerCount, RandomFactory randomFactory) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(randomFactory.nextBoolean());
        points.add(point);
        for (int i = 1; i < playerCount - 1; i++) {
            point = point.next(randomFactory.nextBoolean());
            points.add(point);
        }
        points.add(point.last());
        return new LadderLine(points);
    }

    @Override
    public Position nextPosition(Position position) {
        return points.get(position.position()).move();
    }

    @Override
    public List<Boolean> bridges() {
        return points.stream()
                .limit(points.size() - 1)
                .map(Point::hasRight)
                .collect(toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderLine)) return false;

        LadderLine that = (LadderLine) o;

        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return points != null ? points.hashCode() : 0;
    }
}
