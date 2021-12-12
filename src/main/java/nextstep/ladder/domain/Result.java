package nextstep.ladder.domain;

import java.util.Objects;

public class Result {
    private final String result;

    private Result(final String result) {
        this.result = result;
    }

    public static Result of(final String result) {
        if (result == null || result.trim().isEmpty()) {
            throw new IllegalArgumentException("invalid result: cannot be null or empty");
        }
        return new Result(result.trim());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result1 = (Result) o;
        return Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return result;
    }
}
