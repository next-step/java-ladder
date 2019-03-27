package ladder.domain.players;

import java.util.Objects;

public class Person {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Person(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException();
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    private static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    public String value() {
        return this.name;
    }

    @Override
    public String toString() {
        return beautify();
    }

    private String beautify() {
        return String.format("%" + (MAX_NAME_LENGTH + 1) + "s", name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
