package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.CannotNullOrEmptyException;
import nextstep.ladder.domain.exceptions.ExceedMaxNameLengthException;

public class Name {
    public static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        checkNullOrBlank(name);
        checkExceedMaxLength(name);
        this.name = name;
    }

    private void checkNullOrBlank(String name) {
        if (name == null || name.isEmpty()) {
            throw new CannotNullOrEmptyException();
        }
    }

    private void checkExceedMaxLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new ExceedMaxNameLengthException();
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
