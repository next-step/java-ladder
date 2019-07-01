package com.jaeyeonling.ladder.domain.point;

import com.jaeyeonling.ladder.domain.Position;

import java.util.Objects;

public class Point {

    public static final Point DEFAULT = Point.of(0, 0);

    private final Position x;
    private final Position y;

    private Point(final Position x,
                  final Position y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(final int x,
                           final int y) {
        return of(Position.valueOf(x), Position.valueOf(y));
    }

    public static Point of(Position x,
                           Position y) {
        return new Point(x, y);
    }

    public Point move(final Direction direction) {
        if (direction.isX()) {
            final Position movedX = x.move(direction.getDistance());
            return of(movedX, this.y);
        }
        if (direction.isY()) {
            final Position movedY = y.move(direction.getDistance());
            return of(this.x, movedY);
        }

        return this;
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
        return Objects.equals(this.x, that.x) &&
                Objects.equals(this.y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}
