package ladder.domain;

import ladder.domain.exception.NameLengthOutOfRangeException;

import java.util.Objects;
import java.util.Optional;

public class Name {

    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 5;

    private final String value;

    public Name(final String value) {
        final String refined = Optional.ofNullable(value)
                .map(String::trim)
                .orElseThrow(NameLengthOutOfRangeException::new);
        validateLength(refined);
        this.value = refined;
    }

    private void validateLength(final String value) {
        if (value.length() < MIN_LENGTH || value.length() > MAX_LENGTH) {
            throw new NameLengthOutOfRangeException(value);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
