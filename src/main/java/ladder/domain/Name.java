package ladder.domain;

import ladder.exception.InvalidInputException;

import java.util.Objects;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;
    private static final String INVALID_NAME_LENGTH_MESSAGE = "이름은 " + NAME_MAX_LENGTH + "자를 초과할 수 없습니다.";

    private String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new InvalidInputException(INVALID_NAME_LENGTH_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name user = (Name) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
