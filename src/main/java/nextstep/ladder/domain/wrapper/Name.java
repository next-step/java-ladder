package nextstep.ladder.domain.wrapper;

import java.util.Objects;

import static nextstep.ladder.exception.ExceptionMessage.*;

public class Name {

    private final String name;

    public Name(String name) {
        validateNone(name);
        validateRange(name);

        this.name = name;
    }

    private void validateNone(String name) {
        if (isNone(name)) {
            throw new IllegalArgumentException(NOT_NONE.message());
        }
    }

    private boolean isNone(String name) {
        return name == null || name.isBlank();
    }

    private void validateRange(String name) {
        if (isOutOfRange(name)) {
            throw new IllegalArgumentException(OUT_OF_RANGE.message());
        }
    }

    private boolean isOutOfRange(String name) {
        return name.length() < 1 || name.length() > 5;
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
