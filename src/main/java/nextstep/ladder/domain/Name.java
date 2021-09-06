package nextstep.ladder.domain;

import java.util.Objects;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;
    public static final String ALL_RESULT = "all";
    private final String name;

    public Name(String name) {
        Objects.requireNonNull(name);
        String trimmedName = name.trim();
        validName(trimmedName);
        this.name = name.trim();
    }

    public String name() {
        return name;
    }

    public void validName(String name) {
        if (ALL_RESULT.equals(name)) {
            throw new IllegalArgumentException(ALL_RESULT + "은 사용 할 수 없는 이름입니다.");
        }

        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자만 허용 합니다.");
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
