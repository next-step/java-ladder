package ladder.domain;

import java.util.List;

public class ExecutionResults {

    private final List<ExecutionResult> executionResults;

    public ExecutionResults(List<ExecutionResult> executionResults) {
        this.executionResults = executionResults;
    }

    public ExecutionResult getResult(int resultIndex) {
        return this.executionResults.get(resultIndex);
    }

    public List<ExecutionResult> getExecutionResults() {
        return executionResults;
    }

    public int size() {
        return executionResults.size();
    }
}
