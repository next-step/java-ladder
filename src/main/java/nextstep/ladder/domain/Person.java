package nextstep.ladder.domain;

import java.util.Objects;

public class Person {
    public static final int NAME_LENGTH_LIMIT = 5;
    public static final String LEFT_PAD = "%5s";

    private final String name;

    public Person(final String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("The name allows up to 5 characters.");
        }
        this.name = name;
    }

    public String leftPad() {
        return String.format(LEFT_PAD, name);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }
}
