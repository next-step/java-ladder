package nextstep.ladder.service;

import nextstep.ladder.domain.ExecutionResult;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.dto.LadderResultDto;

public interface LadderService {
	LadderResultDto calculateResult(Ladder ladder, Participants participants, ExecutionResult executionResult);
}
