package ladder.domain;

import ladder.util.StringUtils;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name from(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException(String.format("이름은 최대 %d자 까지 가능합니다.", MAX_NAME_LENGTH));
        }
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException("이름은 공백을 입력할 수 없습니다.");
        }
        return new Name(name);
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
        return String.valueOf(name);
    }
}
