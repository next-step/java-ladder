package domain;

import exception.NegativePositionException;

import java.util.Objects;

public class Position {
    public static final int FIRST_INDEX = 0;
    private int position;

    private Position(int position) {
        if(position < FIRST_INDEX) {
            throw new NegativePositionException();
        }

        this.position = position;
    }

    public static Position of(int position) {
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
