package nextstep.ladder.model;

import java.util.Objects;

public class Name {

    private static final int NAME_MAX_LENGTH = 5;
    private static final String EXCEPTION_NAME_MAX_LENGTH_OVER = "사람 이름은 5글자를 초과할 수 없습니다.";
    private final String name;

    public Name(String name) {
        this.name = validateNameLength(name);
    }

    private String validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_NAME_MAX_LENGTH_OVER);
        }
        return name;
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
