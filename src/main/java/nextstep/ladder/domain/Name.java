package nextstep.ladder.domain;

import nextstep.ladder.exception.BlankNameException;
import nextstep.ladder.exception.NameOverLengthException;

import java.util.Objects;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Name(String name) {
        validateNameLength(name);
        this.value = name;
    }

    private void validateNameLength(String name) {
        if (name.isEmpty()) {
            throw new BlankNameException();
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new NameOverLengthException();
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Name name1 = (Name) obj;
        return Objects.equals(value, name1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
