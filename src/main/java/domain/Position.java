package domain;

import exception.NegativePositionException;

import java.util.Objects;

public class Position {
    public static final Position FIRST = new Position(0);
    private int position;

    private Position(int position) {
        if(position < 0) {
            throw new NegativePositionException();
        }

        this.position = position;
    }

    public static Position of(int position) {
        if(position == 0) {
            return FIRST;
        }

        return new Position(position);
    }

    public int value() {
        return position;
    }

    public Position plus() {
        return new Position(position + 1);
    }

    public Position minus() {
        return new Position(position - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position p = (Position) o;
        return position == p.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
