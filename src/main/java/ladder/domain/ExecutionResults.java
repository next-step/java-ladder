package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExecutionResults {

    private static final String RESULTS_SIZE_SHOULD_BE_EQUAL_TO_THE_NUMBER_OF_PARTICIPANTS = "실행 결과의 사이즈는 참가자 수와 같아야 합니다.";
    private final List<ExecutionResult> executionResults;

    public ExecutionResults(String[] executionResultsInput, int participantsSize) {
        validateExecutionResults(executionResultsInput, participantsSize);
        this.executionResults = convertStringArrayToList(executionResultsInput);
    }

    private void validateExecutionResults(String[] executionResultsInput, int participantsSize) {
        if (executionResultsInput.length != participantsSize) {
            throw new IllegalArgumentException(RESULTS_SIZE_SHOULD_BE_EQUAL_TO_THE_NUMBER_OF_PARTICIPANTS);
        }
    }

    private List<ExecutionResult> convertStringArrayToList(String[] executionResultsInput) {
        return Arrays.stream(executionResultsInput).map(ExecutionResult::new).collect(Collectors.toList());
    }

    public ExecutionResult getEachResult(int index) {
        return executionResults.get(index);
    }

    public List<ExecutionResult> getExecutionResultsAsList() {
        return executionResults;
    }
}
