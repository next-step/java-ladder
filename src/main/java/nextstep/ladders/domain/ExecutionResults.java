package nextstep.ladders.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ExecutionResults {

    public static final String REGEX_COMMA = ",";

    private final List<ExecutionResult> executionResults;

    public ExecutionResults(final String executionResultText) {
        List<String> results = parseExecutionResults(executionResultText);
        this.executionResults = results.stream()
                .map(ExecutionResult::valueOf)
                .collect(Collectors.toList());
    }


    private List<String> parseExecutionResults(final String participantsText) {
        return Arrays.stream(participantsText.split(REGEX_COMMA))
                .collect(Collectors.toList());
    }

    public List<ExecutionResult> getExecutionResult() {
        return Collections.unmodifiableList(executionResults);
    }
}
