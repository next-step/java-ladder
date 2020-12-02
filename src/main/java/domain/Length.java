package domain;

import exception.NegativeLengthException;

public class Length {
    private static final int LENGTH_MIN_BOUNDARY = 0;
    private final int length;


    private Length(final int length) {
        this.length = length;
    }

    public static Length of(final int length) {
        if(length < LENGTH_MIN_BOUNDARY) {
            throw new NegativeLengthException();
        }

        return new Length(length);
    }

    public int getValue() {
        return length;
    }
}
