package ladder.refactoring.domain;

import java.util.Objects;

public class Name {
    private static final int LENGHT_LIMIT = 5;

    private final String name;

    public Name(String name) {
        this.name = name;
    }

    public static Name of(String name) {
        if (name.length() > LENGHT_LIMIT) {
            throw new IllegalArgumentException("이름은 최대 5글자까지만 허용합니다.");
        }
        return new Name(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Name) {
            Name other = (Name) obj;
            return name.equals(other.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
