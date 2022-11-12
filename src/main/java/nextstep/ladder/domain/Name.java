package nextstep.ladder.domain;

import nextstep.ladder.exception.ErrorMessage;
import nextstep.ladder.exception.InvalidLengthOfNameException;

public class Name {
    public static final int LENGTH_OF_NAME_MAX_VALUE = 5;

    private final String name;

    private Name(String name) {
        if (!isValidLengthOfName(name)) {
            throw new InvalidLengthOfNameException(ErrorMessage.INVALID_LENGTH_OF_NAME, LENGTH_OF_NAME_MAX_VALUE);
        }
        this.name = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    private boolean isValidLengthOfName(String name) {
        return name.length() <= LENGTH_OF_NAME_MAX_VALUE;
    }

    public String getName() {
        return name;
    }
}
