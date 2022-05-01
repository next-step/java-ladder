package nextstep.ladder.model;

import nextstep.common.Assert;

import java.util.Objects;

public final class Result {

    private final String result;

    private Result(String result) {
        Assert.hasText(result, "result must not be blank");
        this.result = result;
    }

    static Result from(String name) {
        return new Result(name);
    }

    public String value() {
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Result result1 = (Result) o;
        return Objects.equals(result, result1.result);
    }

    @Override
    public String toString() {
        return "Result{" +
                "result='" + result + '\'' +
                '}';
    }
}
