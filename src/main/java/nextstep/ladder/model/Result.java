package nextstep.ladder.model;

import nextstep.common.Assert;

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
    public String toString() {
        return "Result{" +
                "result='" + result + '\'' +
                '}';
    }
}
