package ladder.model;

import java.util.Collections;
import java.util.List;

public class ExecutionResults {

    private final List<ExecutionResult> executionResults;

    private ExecutionResults(List<ExecutionResult> executionResults) {
        this.executionResults = Collections.unmodifiableList(executionResults);
    }

    public static ExecutionResults create(List<ExecutionResult> executionResults) {
        return new ExecutionResults(executionResults);
    }

    public List<ExecutionResult> getExecutionResults() {
        return executionResults;
    }

    public ExecutionResult getResult(int resultIndex) {
        return executionResults.get(resultIndex);
    }
}
