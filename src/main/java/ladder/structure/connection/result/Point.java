package ladder.structure.connection.result;

import ladder.structure.connection.MoveStrategy;

import java.util.Objects;

public class Point {
    private final static int HEADING_RIGHT = 1;
    private final static int HEADING_LEFT = -1;
    private final static int HEADING_DOWN = 0;
    private final int column; // 줄번호
    private int direction; // 방향

    private Point(int column) {
        this.column = column;
    }

    public static Point of(int column) {
        return new Point(column);
    }

    public void setDirection(Point before, MoveStrategy moveStrategy) {
        if (before.direction == HEADING_RIGHT) {
            this.direction = HEADING_LEFT;
            return;
        }
        setDirection(moveStrategy);
    }

    public void setDirectionOfLast(Point before) {
        if (before.direction == HEADING_RIGHT) {
            this.direction = HEADING_LEFT;
            return;
        }
        this.direction = HEADING_DOWN;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(MoveStrategy moveStrategy) {
        boolean movable = moveStrategy.isMovableToRight();
        if (movable) {
            this.direction = HEADING_RIGHT;
            return;
        }
        this.direction = HEADING_DOWN;
    }

    public Point move() {
        return Point.of(this.column + direction);
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
