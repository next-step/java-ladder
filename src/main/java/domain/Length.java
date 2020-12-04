package domain;

import exception.InvalidLengthException;

import java.util.Objects;

public class Length {
    private static final int LENGTH_MIN_BOUNDARY = 1;
    private final int length;

    private Length(final int length) {
        this.length = length;
    }

    public static Length of(final int length) {
        if(length < LENGTH_MIN_BOUNDARY) {
            throw new InvalidLengthException();
        }

        return new Length(length);
    }

    public int value() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Length)) return false;
        Length length1 = (Length) o;
        return length == length1.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length);
    }
}
