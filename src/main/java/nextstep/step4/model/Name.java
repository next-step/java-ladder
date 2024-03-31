package nextstep.step4.model;

import java.util.Objects;

public class Name {

    public static final int MAX_LENGTH = 5;
    public static final Name EMPTY = new Name("empty");

    private final String name;

    public Name(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("빈 이름은 허용하지 않습니다");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 " + MAX_LENGTH + "까지 가능합니다");
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
        return MAX_LENGTH == name1.MAX_LENGTH && Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MAX_LENGTH, name);
    }
}
