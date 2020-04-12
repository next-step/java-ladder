package nextstep.ladder.domain;

import java.util.Objects;

import nextstep.ladder.view.InputView;

public class Result {
    private final String result;

    public Result(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Result)) { return false; }
        final Result result1 = (Result) o;
        return Objects.equals(getResult(), result1.getResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResult());
    }
}
