package ladder.domain.result;

import ladder.exception.EmptyResultValueException;

import java.util.Objects;

public final class Result {

    private final String value;

    private Result(final String value) {
        this.value = value;
    }

    public static Result valueOf(final String value) {
        validateResultValue(value);
        return new Result(value);
    }

    private static void validateResultValue(final String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new EmptyResultValueException();
        }
    }

    @Override
    public String toString() {
        return value;
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
