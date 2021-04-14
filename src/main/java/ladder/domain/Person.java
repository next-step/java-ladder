package ladder.domain;

import ladder.exception.InvalidNameSizeException;

public final class Person {

    private static final int MAXIMUM_NAME_SIZE = 5;

    private final String name;

    public static final Person of(String name) {
        return new Person(name);
    }

    private Person(String name) {
        validateSize(name);
        this.name = name;
    }

    private final void validateSize(String name) {
        if (name.length() > MAXIMUM_NAME_SIZE) {
            throw new InvalidNameSizeException();
        }
    }

    public final String getName() {
        return name;
    }
}
