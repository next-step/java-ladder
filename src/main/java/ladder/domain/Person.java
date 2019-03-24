package ladder.domain;

import ladder.common.Constants;

public class Person {
    private final String name;

    public Person(String name) {
        if (name.length() > Constants.Person.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return beautify();
    }

    private String beautify() {
        return String.format("%" + (Constants.Person.MAX_NAME_LENGTH + 1) + "s", name);
    }
}
