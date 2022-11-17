package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;

import java.util.Objects;

public class Result {
    private final String result;

    public Result(String result) {
        validateNullOrEmpty(result);
        this.result = result;
    }

    private void validateNullOrEmpty(String result) {
        if (Objects.isNull(result) || result.isEmpty()) {
            throw new LadderGameException(ErrorCode.NULL_OR_EMPTY_INPUT);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;
        Result result1 = (Result) o;
        return Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    public String getResult() {
        return result;
    }
}
