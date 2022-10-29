package laddergame.domain;

import java.util.Objects;

public class Point {

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public boolean isEqualIndex(int index) {
        return this.index == index;
    }

    public boolean isEqualDirection(Direction direction) {
        return this.direction == direction;
    }

    public boolean isConnected(Point point) {
        if (this.index == point.index) {
            return false;
        }

        Point left = this.index < point.index ? this : point;
        Point right = this.index > point.index ? this : point;
        return right.index == left.index + 1
                && left.direction == Direction.RIGHT
                && right.direction == Direction.LEFT;
    }

    public boolean nextPointPossible(Point previousPoint) {
        if (previousPoint.index != this.index - 1) {
            return false;
        }
        if (previousPoint.direction == Direction.RIGHT) {
            return this.direction == Direction.LEFT;
        }
        return this.direction != Direction.LEFT;
    }

    public boolean firstPossible() {
        return this.index == 0
                && this.direction != Direction.LEFT;
    }

    public boolean lastPossible(int totalPoints) {
        return this.index == totalPoints - 1
                && this.direction != Direction.RIGHT;
    }

    public int getNextLineIndex() {
        return this.direction.getNextLinePosition(this.index);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index && direction == point.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }

}
