package nextstep.ladder.domain.common;

import java.util.Objects;
import nextstep.ladder.domain.common.exception.InvalidResultException;

public class Result {

    private final String value;

    public Result(final String value) {
        this.value = value;
    }

    public static Result of(final String value) {
        createValidation(value);
        return new Result(value);
    }

    private static void createValidation(final String value) {
        if (value.equals("꽝")) {
            return;
        }

        try {
            Integer.parseInt(value);
        } catch (final NumberFormatException ex) {
            throw new InvalidResultException();
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Result)) {
            return false;
        }
        final Result result = (Result) o;
        return Objects.equals(getValue(), result.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
