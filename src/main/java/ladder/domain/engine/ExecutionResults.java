package ladder.domain.engine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExecutionResults {
    private static final String MESSAGE_NUMBER_OF_EXECUTION_RESULTS = "실행 결과는 참여자의 수와 일치해야 합니다.";
    private static final String MESSAGE_LENGTH_OF_EXECUTION_RESULT = "실행 결과는 최대 5글자입니다.";
    private static final int MAX_EXECUTION_RESULT_LENGTH = 5;
    private final List<String> executionResults;

    public ExecutionResults(int numberOfPlayers, String[] executionResults){
        validateNumberOfExecutionResults(numberOfPlayers,executionResults);
        for(int i = 0; i < executionResults.length; i++){
            validateLengthOfExecutionResult(executionResults[i]);
        }
        this.executionResults = Arrays.asList(executionResults);
    }

    private void validateNumberOfExecutionResults(int numberOfPlayers, String[] executionResults) {
        if (executionResults.length != numberOfPlayers) {
            throw new IllegalArgumentException(MESSAGE_NUMBER_OF_EXECUTION_RESULTS);
        }
    }

    private void validateLengthOfExecutionResult(String executionResult) {
        if (executionResult.length() > MAX_EXECUTION_RESULT_LENGTH) {
            throw new IllegalArgumentException(MESSAGE_LENGTH_OF_EXECUTION_RESULT);
        }
    }

    public List<String> executionResults(){
        return Collections.unmodifiableList(executionResults);
    }
}
