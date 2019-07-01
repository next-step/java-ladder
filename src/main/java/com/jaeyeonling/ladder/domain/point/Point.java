package com.jaeyeonling.ladder.domain.point;

import java.util.Objects;

public class Point {

    private final Position indexOfLadder;
    private final Position indexOfLine;

    private Point(final Position indexOfLadder,
                  final Position indexOfLine) {
        this.indexOfLadder = indexOfLadder;
        this.indexOfLine = indexOfLine;
    }

    public static Point of(final int indexOfLadder,
                           final int indexOfLine) {
        return of(Position.valueOf(indexOfLadder), Position.valueOf(indexOfLine));
    }

    public static Point of(final Position indexOfLadder,
                           final Position indexOfLine) {
        return new Point(indexOfLadder, indexOfLine);
    }

    public Point move(final Direction direction) {
        if (direction.isX()) {
            final Position movedIndexOfLadder = indexOfLadder.move(direction.getDistance());
            return of(movedIndexOfLadder, this.indexOfLine.next());
        }
        if (direction.isY()) {
            final Position movedIndexOfLine = indexOfLine.move(direction.getDistance());
            return of(this.indexOfLadder, movedIndexOfLine);
        }

        return this;
    }

    public int getIndexOfLadder() {
        return indexOfLadder.getValue();
    }

    public int getIndexOfLine() {
        return indexOfLine.getValue();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }

        final Point that = (Point) o;
        return Objects.equals(this.indexOfLadder, that.indexOfLadder) &&
                Objects.equals(this.indexOfLine, that.indexOfLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.indexOfLadder, this.indexOfLine);
    }
}
