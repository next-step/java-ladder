package ladder.domain;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null 일 수 없습니다.");
        }
        validateNameLength(name);
        this.name = name;
    }

    public int length() {
        return name.length();
    }

    private void validateNameLength(String name) {
        if (name.length() > 5 || name.length() <= 0) {
            throw new IllegalArgumentException("사람 이름은 1 ~ 5 글자를 만족해야 합니다.");
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
        return name.hashCode();
    }
}
