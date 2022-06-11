package ladder.dto;

import ladder.domain.ExecutionResult;
import ladder.exception.ParticipantNotFoundException;

import java.util.Collections;
import java.util.Map;

public class LadderResultDto {

    private final Map<String, ExecutionResult> results;

    public LadderResultDto(Map<String, ExecutionResult> results) {
        this.results = Collections.unmodifiableMap(results);
    }

    public ExecutionResult showLadderResult(String participantName) {
        ExecutionResult executionResult = results.get(participantName);
        validateParticipant(executionResult);
        return executionResult;
    }

    private void validateParticipant(ExecutionResult executionResult) {
        if (executionResult == null) {
            throw new ParticipantNotFoundException();
        }
    }

    public Map<String, ExecutionResult> getResults() {
        return results;
    }
}
