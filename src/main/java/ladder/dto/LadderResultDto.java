package ladder.dto;

import ladder.domain.ExecutionResult;

import java.util.Collections;
import java.util.Map;

public class LadderResultDto {

    private final Map<String, ExecutionResult> results;

    public LadderResultDto(Map<String, ExecutionResult> results) {
        this.results = Collections.unmodifiableMap(results);
    }

    public ExecutionResult showLadderResult(String participantName) {
        return results.get(participantName);
    }

    public Map<String, ExecutionResult> getResults() {
        return results;
    }
}
