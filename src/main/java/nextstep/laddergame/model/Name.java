package nextstep.laddergame.model;

import nextstep.laddergame.exception.InvalidNameException;

public class Name {

    private static final int LENGTH_LINMIT = 5;

    private final String name;

    public Name(String name) {
        validateOrThrow(name.trim());
        this.name = name.trim();
    }

    private void validateOrThrow(String name) {
        if (name == null || name.length() > LENGTH_LINMIT) {
            throw new InvalidNameException("name must be longer than " + LENGTH_LINMIT);
        }
    }
}
