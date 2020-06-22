package laddergame.domain.vo;

import java.util.Objects;

public class Name {
    private static final int NAME_LENGTH_BOUND = 5;
    private final String name;

    public Name(String name) {
        validateNullOrEmpty(name);
        validateLength(name);
        this.name = name.trim();
    }

    public String getName() {
        return this.name;
    }

    public boolean isSameName(final String name) {
        return this.name.equals(name);
    }

    private void validateNullOrEmpty(String name) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 Null 이나 공백일 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.trim().length() > NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException("이름은 5글자를 넘을 수 없습니다. - " + name.trim());
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name1 = (Name) o;
        return Objects.equals(getName(), name1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
