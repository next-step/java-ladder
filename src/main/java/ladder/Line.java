package ladder;

import nextstep.ladder.Direction;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(int countOfPersons, PointStrategy strategy) {
        this.points = createPoints(countOfPersons, strategy);
    }

    private List<Point> createPoints(int countOfPersons, PointStrategy strategy) {
        List<Point> points = new ArrayList<>();

        Point first = createFirstPoint(strategy);
        points.add(first);

        Point prev = first;
        for (int i = 1; i < countOfPersons - 1; i++) {
            Point next = createNextPoint(prev, strategy);
            points.add(next);
            prev = next;
        }

        points.add(prev.last());
        return points;
    }

    private Point createFirstPoint(PointStrategy strategy) {
        return Point.first(strategy.generate());
    }

    private Point createNextPoint(Point prev, PointStrategy strategy) {
        return prev.next(isConsecutiveLines(prev, strategy.generate()));
    }

    private boolean isConsecutiveLines(Point prev, boolean nextDirection) {
        return (!prev.isCurrent() || !nextDirection) && nextDirection;
    }
    public int move(int index) {
        Direction direction = points.get(index).move();
        if (direction == Direction.LEFT) {
            return index - 1;
        }
        if (direction == Direction.RIGHT) {
            return index + 1;
        }
        return index;
    }

    public int size() {
        return points.size();
    }

    public List<Point> points() {
        return List.copyOf(points);
    }

}