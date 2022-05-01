package ladder.converter;

import ladder.dto.LadderResultDto;
import ladder.model.ExecutionResult;
import ladder.model.ExecutionResults;
import ladder.model.Ladder;
import ladder.model.Participant;
import ladder.model.Participants;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultConverter {

    public static LadderResultDto convertIntoLadderResultDto(
            Participants participants,
            ExecutionResults executionResults,
            Ladder ladder
    ) {
        Map<String, ExecutionResult> results = participants.getParticipants().stream()
                .collect(Collectors.toMap(Participant::toString, participant -> {
                    int startIndex = participants.getLocation(participant);
                    int resultIndex = ladder.move(startIndex);
                    return executionResults.getResult(resultIndex);
                }));
        return LadderResultDto.create(results);
    }
}
