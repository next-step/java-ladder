package nextstep.ladder.domain;

import java.util.Objects;

public class Name {

    private static final int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateBlank(name);
        validateNameOverThenFive(name);
        this.name = name;
    }

    private void validateBlank(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isBlank(String name) {
        return name == null || name.isBlank();
    }

    private static void validateNameOverThenFive(String name) {
        if (isOverThenFive(name)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isOverThenFive(String name) {
        return name.length() > MAX_LENGTH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
