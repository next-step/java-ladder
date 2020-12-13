package nextstep.step4.domain;

import java.util.Objects;

public class Result {

    private int index;
    private final String result;

    private Result(int index, String result) {
        this.index = index;
        this.result = result;
    }

    public static Result of(int index, String result) {
        return new Result(index, result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result1 = (Result) o;
        return index == result1.index &&
                Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, result);
    }

    @Override
    public String toString() {
        return result;
    }
}
