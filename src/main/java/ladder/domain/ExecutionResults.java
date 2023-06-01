package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ExecutionResults {

    private final List<ExecutionResult> executionResults;

    public ExecutionResults(List<String> executionResultsInput, int participantSize) {
        validateExecutionResults(executionResultsInput.size(), participantSize);
        this.executionResults = convertStringListToExecutionResultList(executionResultsInput);
    }

    private void validateExecutionResults(int executionResultsInputSize, int participantSize) {
        if (executionResultsInputSize != participantSize) {
            throw new IllegalArgumentException(String.format("입력한 실행 결과 수와 참가자 수가 같아야 합니다. executionResultsInputSize : %d, participantSize : %d", executionResultsInputSize, participantSize));
        }
    }

    private List<ExecutionResult> convertStringListToExecutionResultList(List<String> executionResultsInput) {
        return executionResultsInput.stream()
                .map(ExecutionResult::new)
                .collect(Collectors.toList());
    }

    public ExecutionResult getEachResult(int index) {
        return executionResults.get(index);
    }

    public List<ExecutionResult> getExecutionResultsAsList() {
        return executionResults;
    }

    public int getExecutionResultsSize() {
        return executionResults.size();
    }
}
