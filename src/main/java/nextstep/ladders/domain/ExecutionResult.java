package nextstep.ladders.domain;

import java.util.Objects;

public class ExecutionResult {

    private final String result;

    private ExecutionResult(final String result) {
        this.result = result;
    }

    public static ExecutionResult valueOf(final String result) {
        return new ExecutionResult(result);
    }

    public String value() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExecutionResult that = (ExecutionResult) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
