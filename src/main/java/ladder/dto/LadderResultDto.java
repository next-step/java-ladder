package ladder.dto;

import ladder.model.ExecutionResult;

import java.util.Collections;
import java.util.Map;

public class LadderResultDto {

    private final Map<String, ExecutionResult> results;

    private LadderResultDto(Map<String, ExecutionResult> results) {
        this.results = Collections.unmodifiableMap(results);
    }

    public static LadderResultDto create(Map<String, ExecutionResult> results) {
        return new LadderResultDto(results);
    }

    public ExecutionResult showLadderResult(String participantName) {
        return results.get(participantName);
    }

    public Map<String, ExecutionResult> getResults() {
        return results;
    }

}
