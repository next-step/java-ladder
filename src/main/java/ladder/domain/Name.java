package ladder.domain;

import ladder.exception.InvalidInputException;

import java.util.Objects;

public class Name {
    private static final String INVALID_NAME_LENGTH_MESSAGE = "이름은 5자를 초과할 수 없습니다.";

    private String name;

    public Name(String name) {
        this.name = valid(name);
    }

    private String valid(String name) {
        if (name.length() > 5) {
            throw new InvalidInputException(INVALID_NAME_LENGTH_MESSAGE);
        }
        return name;
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
