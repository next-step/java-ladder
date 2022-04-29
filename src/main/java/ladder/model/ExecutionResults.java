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

}
