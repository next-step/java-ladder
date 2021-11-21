package nextstep.refactor_ladder.domain;

import nextstep.refactor_ladder.domain.value.ExecutionResult;

import java.util.List;

public class ExecutionResults {
    private final List<ExecutionResult> executionResults;

    private ExecutionResults(List<ExecutionResult> executionResults) {
        this.executionResults = executionResults;
    }

    public static ExecutionResults from(List<ExecutionResult> executionResults) {
        return new ExecutionResults(executionResults);
    }

    public ExecutionResult getResult(int finalResult) {
        return executionResults.get(finalResult);
    }
}
