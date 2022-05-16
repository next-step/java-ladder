package ladder.domain;

import ladder.exception.InvalidNameException;

public class Name {

    public static final int MAX_LENGTH = 5;

    private final String value;

    public Name(String value) {
        if (isLowerMaxLength(value)) {
            throw new InvalidNameException();
        }
        this.value = value;
    }

    private boolean isLowerMaxLength(String value) {
        return value.length() > MAX_LENGTH;
    }
}
