package com.ladder.model;

import com.ladder.exception.NegativeNumberException;

import java.util.Objects;

public class Position {

    static final int MIN_NUMBER_OF_POSITION = 0;
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position of(int position) {
        if (position < MIN_NUMBER_OF_POSITION) {
            throw new NegativeNumberException();
        }
        return new Position(position);
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

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }
}
