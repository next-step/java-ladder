package nextstep.ladder.domain;

import java.util.List;

public class ExecutionResults {

    private List<ExecutionResult> executionResults;

    private ExecutionResults(List<ExecutionResult> executionResults) {
        this.executionResults = executionResults;
    }

    public static ExecutionResults of(List<String> executionResults) {
        return null;
    }
}
