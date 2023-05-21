package nextstep.ladder.domain;

import java.util.Objects;

public class Result {

    private final String value;

    public Result(String value) {
        this.value = value;
    }

    public static Result from(String value) {
        return new Result(value);
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

    @Override
    public String toString() {
        return value;
    }
}
