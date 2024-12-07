package ladder.domain.engine;

import ladder.exception.InvalidNameException;

import java.util.Objects;

public abstract class Name {
    public static final String NOT_ALLOW_EMPTY_NAME_MESSAGE = "이름에 공백이 들어갈 수 없습니다.";
    public static final String NOT_ALLOW_EXCEED_MAX_NAME_LENGTH_MESSAGE = "이름을 5글자를 초과할수 없습니다.";
    public static final int DEFAULT_MAX_NAME_LENGTH = 5;
    public static final int MAX_NAME_LENGTH = 5;
    public static final String NAME_EMPTY_STRING = "";

    protected final String name;

    public Name(String name) {
        if (name == null || name.equals(NAME_EMPTY_STRING)) {
            throw new InvalidNameException(NOT_ALLOW_EMPTY_NAME_MESSAGE);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new InvalidNameException(NOT_ALLOW_EXCEED_MAX_NAME_LENGTH_MESSAGE);
        }
        this.name = name;
    }

    public abstract int length();

    public abstract String name();

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
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
