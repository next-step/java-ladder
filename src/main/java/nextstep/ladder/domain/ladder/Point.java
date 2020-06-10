package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Point {
    private static final int FIRST_POINT_INDEX = 0;
    private static final boolean FIRST_POINT_INIT_STATUS = false;

    private final int index;
    private final Direction direction;

    public Point(boolean currentStatus) {
        this(0, new Direction(currentStatus, false));
    }

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(PointAddStrategy pointAddStrategy) {
        return new Point(FIRST_POINT_INDEX,
                new Direction(
                        FIRST_POINT_INIT_STATUS, pointAddStrategy.confirmPointLocation(!FIRST_POINT_INIT_STATUS))
        );
    }

    public Point next(PointAddStrategy pointAddStrategy) {
        return new Point(this.index + 1, this.direction.next(pointAddStrategy));
    }

    public boolean getCurrentStatus() {
        return this.direction.getCurrentStatus();
    }

    public int move() {
        return this.index + HorizontalMoveStrategy.findByDirection(this.direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index &&
                Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }
}
