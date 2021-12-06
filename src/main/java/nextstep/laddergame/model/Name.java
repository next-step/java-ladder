package nextstep.laddergame.model;

import nextstep.laddergame.exception.InvalidNameException;

public class Name {

    private static final int LENGTH_LIMIT = 5;

    private final String name;

    public Name(String name) {
        validateOrThrow(name.trim());
        this.name = name.trim();
    }

    private void validateOrThrow(String name) {
        if (name == null || name.length() > LENGTH_LIMIT) {
            throw new InvalidNameException("name must be longer than " + LENGTH_LIMIT);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
