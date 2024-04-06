package nextstep.ladder.domain;

import java.util.Objects;

public class ExecutionResult {
    private final String executionResult;

    public ExecutionResult(String executionResult) {
        validateIfEmpty(executionResult);
        this.executionResult = executionResult;
    }

    private void validateIfEmpty(String executionResult) {
        if(executionResult == null || executionResult.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExecutionResult)) return false;
        ExecutionResult that = (ExecutionResult) o;
        return Objects.equals(executionResult, that.executionResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(executionResult);
    }

    public String getExecutionResult() {
        return executionResult;
    }
}
