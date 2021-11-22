package nextstep.ladder.converter;

import static java.util.stream.Collectors.*;

import nextstep.ladder.domain.ExecutionResult;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.dto.LadderResultDto;

public class ResultConverter {
	public LadderResultDto convert(Ladder ladder, Participants participants, ExecutionResult executionResult) {
		return participants.getValues().stream()
			.collect(collectingAndThen(toMap(Participant::toString, participant -> {
				int startIndex = participants.getIndex(participant);
				int movedLastIndex = ladder.move(startIndex);
				return executionResult.getResult(movedLastIndex);
			}), LadderResultDto::new));
	}
}
