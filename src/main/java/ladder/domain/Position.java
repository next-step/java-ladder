package ladder.domain;

import java.util.Objects;

public class Position {
    private final int position;

    private Position(int position) {
        System.out.println("position = " + position);
        this.position = position;
    }

    public static Position from() {
        return from(0);
    }
    public static Position from(int position) {
        return new Position(position);
    }

    public Position left() {
        return new Position(this.position - 1);
    }

    public Position right() {
        return new Position(this.position + 1);
    }

    public int value() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
