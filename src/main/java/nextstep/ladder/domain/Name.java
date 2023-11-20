package nextstep.ladder.domain;

import nextstep.ladder.exception.NameOverLengthException;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new NameOverLengthException();
        }
    }

    public String name() {
        return name;
    }
}
