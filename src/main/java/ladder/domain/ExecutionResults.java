package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExecutionResults {
    private static final String MESSAGE_NUMBER_OF_EXECUTION_RESULTS = "실행 결과는 참여자의 수와 일치해야 합니다.";
    private final List<String> executionResults;

    public ExecutionResults(int numberOfPlayers, String[] executionResults){
        validate(numberOfPlayers,executionResults);
        this.executionResults = Arrays.asList(executionResults);
    }

    private void validate(int numberOfPlayers, String[] executionResults) {
        if (executionResults.length != numberOfPlayers) {
            throw new IllegalArgumentException(MESSAGE_NUMBER_OF_EXECUTION_RESULTS);
        }
    }

    public List<String> executionResults(){
        return Collections.unmodifiableList(executionResults);
    }
}
