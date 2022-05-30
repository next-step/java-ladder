package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.CannotNullOrEmptyException;
import nextstep.ladder.domain.exceptions.ExceedMaxNameLengthException;

import java.util.Objects;

public class Name {
    public static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        checkNullOrBlank(name);
        checkExceedMaxLength(name);
        this.name = name;
    }

    private void checkNullOrBlank(String name) {
        if (name == null || name.isEmpty()) {
            throw new CannotNullOrEmptyException();
        }
    }

    private void checkExceedMaxLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new ExceedMaxNameLengthException();
        }
    }

    public boolean match(String name) {
        return Objects.equals(this.name, name);
    }

    @Override
    public String toString() {
        return this.name;
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
