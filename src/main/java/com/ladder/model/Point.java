package com.ladder.model;

import java.util.Objects;

import static com.ladder.model.Direction.DOWN;
import static com.ladder.model.Direction.LEFT;

public class Point {

    static final int INDEX_OF_FIRST = 0;
    private final Position indexOfLadder;
    private final Direction direction;

    private Point(Position indexOfLadder, Direction direction) {
        this.indexOfLadder = indexOfLadder;
        this.direction = direction;
    }

    static Point of(Position indexOfLadder, Direction direction) {
        return new Point(indexOfLadder, direction);
    }

    static Point of(int indexOfLadder, Direction direction) {
        return of(Position.of(indexOfLadder), direction);
    }

    static Point ofFirst(Direction direction) {
        return of(INDEX_OF_FIRST, direction);
    }

    Point next(Direction direction) {
        return of(indexOfLadder.moveForward(), direction);
    }

    Point last() {
        Direction afterDirection = this.direction.isRight() ? LEFT : DOWN;
        return of(indexOfLadder.moveForward(), afterDirection);
    }

    Position move() {
        return direction.move(indexOfLadder);
    }

    public boolean isRight() {
        return direction.isRight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(indexOfLadder, point.indexOfLadder) &&
                direction == point.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(indexOfLadder, direction);
    }

    @Override
    public String toString() {
        return "Point{" +
                "indexOfLadder=" + indexOfLadder +
                ", direction=" + direction +
                '}';
    }
}
