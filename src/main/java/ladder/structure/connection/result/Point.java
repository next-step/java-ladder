package ladder.structure.connection.result;

import ladder.structure.connection.MoveStrategy;

import java.util.Objects;

public class Point {
    private final int column; // 줄번호
    private Direction direction; // 방향

    private Point(int column) {
        this.column = column;
    }

    public static Point of(int column) {
        return new Point(column);
    }

    public static int compare(Point a, Point b) {
        return a.column - b.column;
    }

    public Point setDirection(Point before, MoveStrategy moveStrategy) {
        if (before != null && before.direction == Direction.RIGHT) {
            this.direction = Direction.LEFT;
            return this;
        }
        boolean movable = moveStrategy.isMovableToRight();
        if (movable) {
            this.direction = Direction.RIGHT;
            return this;
        }
        this.direction = Direction.STAY;
        return this;
    }

    public void setDirectionOfLast() {
        if (this.direction == Direction.RIGHT) {
            this.direction = Direction.STAY;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public Point move() {
        return Point.of(this.column + direction.getNum());
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point1 = (Point) o;
        return column == point1.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column);
    }
}
