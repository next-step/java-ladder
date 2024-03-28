package nextstep.ladder.model;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름이 비어 있습니다");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5자를 초과할 수 없습니다");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Name name1 = (Name) other;
        return MAX_NAME_LENGTH == name1.MAX_NAME_LENGTH && Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MAX_NAME_LENGTH, name);
    }
}
