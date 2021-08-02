package nextstep.ladder.domain.common;

import nextstep.ladder.domain.common.exception.InvalidNameException;

public class Name {

    private static final int NAME_LENGTH_MAX = 5;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name create(String name) {
        createValidation(name);
        return new Name(name);
    }

    private static void createValidation(String name) {
        if (name.length() > NAME_LENGTH_MAX) {
            throw new InvalidNameException();
        }
    }

    public String getName() {
        return name;
    }
}
