package ladder.domain;

import ladder.exception.InvalidNameException;

public class Person {

    public static final int MAX_LENGTH = 5;

    private final String name;

    public Person(String name) {
        if (isLowerMaxLength(name)) {
            throw new InvalidNameException();
        }
        this.name = name;
    }

    private boolean isLowerMaxLength(String value) {
        return value.length() > MAX_LENGTH;
    }
}
