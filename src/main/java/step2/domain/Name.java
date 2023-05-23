package step2.domain;

import java.util.Objects;

public class Name {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 빈값일 수 없습니다.");
        }

        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 %d자를 넘길 수 없습니다.", MAX_LENGTH));
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

    @Override
    public String toString() {
        return name;
    }
}
