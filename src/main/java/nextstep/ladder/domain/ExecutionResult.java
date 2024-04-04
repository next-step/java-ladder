package nextstep.ladder.domain;

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
}
