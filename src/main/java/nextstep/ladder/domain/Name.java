package nextstep.ladder.domain;

import nextstep.ladder.exception.ExceedNameLengthException;

public class Name {
    private static final int PERSON_MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateNameSize(name);
        this.name = name;
    }

    private void validateNameSize(String name) {
        if (name.length() > PERSON_MAX_LENGTH) {
            throw new ExceedNameLengthException(name);
        }
    }
}
