package nextstep.ladder.domain;

import nextstep.ladder.exception.BlankNameException;
import nextstep.ladder.exception.NameOverLengthException;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Name(String name) {
        validateNameLength(name);
        this.value = name;
    }

    private void validateNameLength(String name) {
        if (name.isEmpty()) {
            throw new BlankNameException();
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new NameOverLengthException();
        }
    }

    public String value() {
        return value;
    }
}
