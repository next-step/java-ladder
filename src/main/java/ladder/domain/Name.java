package ladder.domain;

import ladder.exception.InvalidNameException;

import java.util.Objects;

public class Name {
    public static final String NOT_ALLOW_EMPTY_NAME = "이름에 공백이 들어갈 수 없습니다.";
    private final String name;

    public Name(String name) {
        if (name == null || name.equals("")) {
            throw new InvalidNameException(NOT_ALLOW_EMPTY_NAME);
        }
        this.name = name;
    }

    public int length() {
        return name.length();
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
