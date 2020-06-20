package nextstep.ladder.domain;

import nextstep.ladder.constant.LadderConstants;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ExecutionResults {

    private List<ExecutionResult> executionResults;

    private ExecutionResults() {
        this.executionResults = new ArrayList<>();
    }

    public static ExecutionResults of(List<String> executionResults) {
        validateExecutionResults(executionResults);

        ExecutionResults results = new ExecutionResults();
        executionResults.forEach(executionResult -> results.addToExecutionResults(ExecutionResult.of(executionResult)));
        return results;
    }

    private static void validateExecutionResults(List<String> executionResults) {
        if (CollectionUtils.isEmpty(executionResults)) {
            throw new IllegalArgumentException(LadderConstants.EXECUTION_RESULT_ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
        }
    }

    private void addToExecutionResults(ExecutionResult executionResult) {
        this.executionResults.add(executionResult);
    }

    public List<ExecutionResult> getExecutionResults() {
        return this.executionResults;
    }
}
