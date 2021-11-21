package nextstep.ladder.service;

import static java.util.stream.Collectors.*;

import java.util.concurrent.atomic.AtomicInteger;

import nextstep.ladder.domain.ExecutionResult;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.dto.LadderResultDto;

public class LadderServiceImpl implements LadderService {
	@Override
	public LadderResultDto calculateResult(Ladder ladder, Participants participants, ExecutionResult executionResult) {
		return participants.getValues().stream()
			.collect(collectingAndThen(toMap(Participant::toString, participant -> {
				AtomicInteger index = new AtomicInteger(participants.getIndex(participant));
				ladder.getLines().forEach(line -> index.set(line.move(index.get())));
				return executionResult.getResult(index.get());
			}), LadderResultDto::new));
	}
}
