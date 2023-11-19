package ladder.domain;

import ladder.exception.NameBlankException;
import ladder.exception.NameExceedException;

public class Name {

    private static final int MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateBlank(name);
        validateLength(name);
    }

    private void validateBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new NameBlankException();
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new NameExceedException();
        }
    }

    public String name() {
        return this.name;
    }

}
