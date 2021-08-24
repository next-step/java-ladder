package ladder.domain.result;

import ladder.exception.EmptyResultValueException;

import java.util.Objects;

public class Result {

    private final String value;

    public Result(String value) {
        validateResultValue(value);
        this.value = value;
    }

    private void validateResultValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new EmptyResultValueException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(value, result.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
