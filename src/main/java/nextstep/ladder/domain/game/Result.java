package nextstep.ladder.domain.game;

import java.util.Objects;

public class Result {

    private final String result;

    private Result(String result) {
        this.result = result;
    }

    public static Result from(String result) {
        return new Result(result);
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
