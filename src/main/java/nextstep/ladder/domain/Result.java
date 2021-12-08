package nextstep.ladder.domain;

import nextstep.ladder.exception.ResultException;

import java.util.Objects;

public class Result {
    private static final int RESULT_MAX_LENGTH = 5;

    private final String result;

    private Result(String result) {
        validateResult(result);
        this.result = result;
    }

    public static Result from(String result) {
        return new Result(result);
    }

    private void validateResult(String result) {
        if (Objects.isNull(result) || result.isEmpty()) {
            throw new ResultException();
        }
        if (result.length() > RESULT_MAX_LENGTH) {
            throw new ResultException();
        }
    }

    public String name() {
        return result;
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
}
