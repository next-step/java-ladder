package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.exception.ExecutionResultNullPointerException;
import nextstep.ladder.exception.ExecutionResultSizeException;

public class ExecutionResult {

    private static final String DELIMITER = ",";

    private List<String> executionResult;

    private ExecutionResult(List<String> executionResult) {
        this.executionResult = executionResult;
    }

    public static ExecutionResult of(String result, int size) {
        List<String> executionResult = toCollection(result);
        validSize(executionResult, size);
        return new ExecutionResult(executionResult);
    }

    public List<String> getExecutionResult() {
        return Collections.unmodifiableList(executionResult);
    }

    public String get(int index) {
        return executionResult.get(index);
    }

    private static List<String> toCollection(String result) {
        validEmpty(result);

        return Arrays.stream(result.split(DELIMITER))
            .collect(Collectors.toCollection(ArrayList::new));
    }

    private static void validEmpty(String result) {
        if (result == null || result.isEmpty()) {
            throw new ExecutionResultNullPointerException();
        }
    }

    private static void validSize(List<String> executionResult, int size) {
        if (executionResult.size() != size) {
            throw new ExecutionResultSizeException();
        }
    }

}
