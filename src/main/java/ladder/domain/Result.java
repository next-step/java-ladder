package ladder.domain;

import ladder.exception.ResultBlankException;

import java.util.Objects;

public class Result {

    private final String result;

    public Result(String result) {
        validate(result);
        this.result = result;
    }

    private void validate(String result) {
        if (result == null || result.isBlank()) {
            throw new ResultBlankException();
        }
    }

    public String result() {
        return this.result;
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
