package nextstep.ladder;

import nextstep.ladder.exception.PersonNameLengthExceedException;

public class Person {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Person(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (exceedNameLength(name)) {
            throw new PersonNameLengthExceedException(name);
        }
    }

    private boolean exceedNameLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    public String getName() {
        return this.name;
    }
}
