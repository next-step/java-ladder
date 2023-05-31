package ladder.domain;

public class ExecutionResult {

    private final String executionResult;

    public ExecutionResult(String executionResult) {
        this.executionResult = executionResult;
    }

    public String getExecutionResult() {
        return executionResult;
    }

    @Override
    public String toString() {
        return executionResult;
    }
}
