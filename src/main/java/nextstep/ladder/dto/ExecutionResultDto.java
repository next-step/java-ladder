package nextstep.ladder.dto;

import java.util.HashMap;
import java.util.Map;
import nextstep.ladder.domain.Participants;

public class ExecutionResultDto {
    private static final String ALL_RESULT_DELIMITER = " : ";
    private static final String LINE_BREAK = "\n";

    private final Map<String, String> executionResult;

    public ExecutionResultDto(Map<String, String> executionResult) {
        this.executionResult = executionResult;
    }

    public ExecutionResultDto(Participants participants, ResultsDto resultsDto) {
        this(convertToMap(participants, resultsDto));
    }

    private static Map<String, String> convertToMap(Participants participants, ResultsDto results) {
        Map<String, String> executionResult = new HashMap<>();
        for (int i = 0; i < participants.getValues().size(); i++) {
            executionResult.put(participants.getValues().get(i).toString(), results.getValues().get(i));
        }

        return executionResult;
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
