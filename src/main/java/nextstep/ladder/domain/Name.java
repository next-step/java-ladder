package nextstep.ladder.domain;

import java.util.Objects;

public class Name {
    private static int LENGTH_LIMIT = 5;
    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name from(String name) {
        validate(name);
        return new Name(name);
    }

    private static void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("참여자의 이름은 공백일 수 없습니다.");
        }

        if (name.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException("참여자의 이름은 5자를 초과할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return String.format("%-5s", name);
    }
}
