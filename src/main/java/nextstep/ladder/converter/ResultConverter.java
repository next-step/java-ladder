package nextstep.ladder.converter;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import nextstep.ladder.domain.ExecutionResult;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.dto.LadderResultDto;

public class ResultConverter {
	public LadderResultDto convert(Ladder ladder, Participants participants, ExecutionResult executionResult) {
		return participants.getValues().stream()
			.collect(collectingAndThen(toMap(Participant::toString, participant -> {
				int movedLastIndex = getMovedLastIndex(ladder.getLines(), participants.getIndex(participant));
				return executionResult.getResult(movedLastIndex);
			}), LadderResultDto::new));
	}

	private int getMovedLastIndex(List<Line> lines, int startIndex) {
		AtomicInteger index = new AtomicInteger(startIndex);
		lines.forEach(line -> index.set(line.move(index.get())));
		return index.get();
	}
}
