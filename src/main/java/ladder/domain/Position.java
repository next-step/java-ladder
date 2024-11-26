package ladder.domain;

import java.util.Objects;

public class Position {
    private final X x;
    private final Y y;

    public Position(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
        this(new X(X.MINIMAL_VALUE), new Y(Y.MINIMAL_VALUE));
    }

    public Position(int x, int y) {
        this(new X(x), new Y(y));
    }

    public Position move(Point point) {
        if (point.getCurrent()) {
            return new Position(x.moveRight(), y.moveDown());
        }
        if (point.getPrev()) {
            return new Position(x.moveLeft(), y.moveDown());
        }
        return new Position(x, y.moveDown());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(x, position.x) && Objects.equals(y, position.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
