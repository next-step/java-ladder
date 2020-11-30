package domain;

import exception.NegativeLengthException;

public class Length {
    private final int length;
    private static final int LENGTH_MIN_BOUNDARY = 0;

    private Length(final int length) {
        this.length = length;
    }

    public static Length of(final int length) throws NegativeLengthException {
        if(length < LENGTH_MIN_BOUNDARY) {
            throw new NegativeLengthException();
        }

        return new Length(length);
    }

    public int getValue() {
        return length;
    }
}
