package ladder.converter;

import ladder.domain.*;
import ladder.dto.LadderResultDto;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultConverter {

    public static LadderResultDto convertToResultDto(
            Ladder ladder,
            ExecutionResults executionResults,
            Participants participants
    ) {
        Map<String, ExecutionResult> results = participants.getParticipants().stream()
                .collect(Collectors.toMap(Participant::toString, participant -> {
                    int startIndex = participants.getLocation(participant);
                    int resultIndex = ladder.move(startIndex);
                    return executionResults.getResult(resultIndex);
                }));
        return new LadderResultDto(results);
    }
}
