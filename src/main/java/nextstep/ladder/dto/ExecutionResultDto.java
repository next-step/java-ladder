package nextstep.ladder.dto;

import java.util.Map;

public class ExecutionResultDto {
    private static final String ALL_RESULT_DELIMITER = " : ";
    private static final String LINE_BREAK = "\n";

    private final Map<String, String> executionResult;

    public ExecutionResultDto(Map<String, String> executionResult) {
        this.executionResult = executionResult;
    }

    public StringBuilder executionAllResult() {
        StringBuilder stringBuilder = new StringBuilder();
        executionResult.forEach((key, value) -> {
            stringBuilder.append(key);
            stringBuilder.append(ALL_RESULT_DELIMITER);
            stringBuilder.append(value);
            stringBuilder.append(LINE_BREAK);
        });

        return stringBuilder;
    }

    public String getExecutionResult(String key) {
        return executionResult.get(key);
    }
}
