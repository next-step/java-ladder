package nextstep.ladder.Model;

import java.util.Objects;

public class Name {

    private static final String NAME_IS_NOT_NULL_OR_BLANK_ERROR = "이름을 정할 때 Null 혹은 빈값을 올 수 없습니다.";
    private static final String NAME_LENGTH_LIMIT_ERROR = "이름은 5자를 초과할 수 없습니다";
    private static final int STANDARD_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (isNullOrBlank(name)) {
            throw new IllegalArgumentException(NAME_IS_NOT_NULL_OR_BLANK_ERROR);
        }
        if (isOverLength(name)) {
            throw new IllegalArgumentException(NAME_LENGTH_LIMIT_ERROR);
        }
    }

    private static boolean isOverLength(String name) {
        return name.length() > STANDARD_NAME_LENGTH;
    }

    private static boolean isNullOrBlank(String name) {
        return name == null || name.isEmpty();
    }

    @Override
    public String toString() {
        return name;
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
        return Objects.hash(name);
    }
}
