package domain;

import java.util.Objects;

public class Name {
    public static final String NAME_LENGTH_CANT_OVER_FIVE = "이름은 5자를 초과할 수 없습니다.";
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public static Name from(String name) {
        return new Name(name);
    }

    public Name(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_CANT_OVER_FIVE);
        }
        this.name = name;
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
        return name;
    }
}
