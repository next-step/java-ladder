package nextstep.ladder.domain;

import java.util.List;

public class ExecutionsResults {
    private final List<String> executionResults;

    private ExecutionsResults(List<String> executionResults) {
        this.executionResults = executionResults;
    }

    public static ExecutionsResults of(List<String> executionResultInput) {
        return new ExecutionsResults(executionResultInput);
    }

    public int size() {
        return executionResults.size();
    }
}
