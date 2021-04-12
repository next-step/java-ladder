package ladder.domain;

import ladder.exception.InvalidNameSizeException;

public final class Person {

    public static final int MAXIMUM_NAME_SIZE = 5;

    private final String name;

    private Person(String name) {
        validateSize(name);
        this.name = name;
    }

    private final void validateSize(String name) {
        if(name.length() > MAXIMUM_NAME_SIZE) {
            throw new InvalidNameSizeException();
        }
    }

    public static final Person of(String name) {
        return new Person(name);
    }
}
