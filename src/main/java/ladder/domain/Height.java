package ladder.domain;

import ladder.exception.InvalidHeightException;

public class Height {

    public static final int MIN_VALUE = 1;

    private final int value;

    public Height(int value) {
        if (value < MIN_VALUE) {
            throw new InvalidHeightException();
        }
        this.value = value;
    }

    public int value() {
        return value;
    }
}
