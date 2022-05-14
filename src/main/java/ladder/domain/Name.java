package ladder.domain;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

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
        if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("사람 이름은 1 ~ 5 글자를 만족해야 합니다. 현재 이름 길이 : %d", name.length()));
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
