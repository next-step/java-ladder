package step4.domain;

import java.util.Objects;

public class Name {
    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    private Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    public String name() {
        return name;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH || name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 최소 1자 이상 5자 이하여야 합니다.");
        }
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
}
