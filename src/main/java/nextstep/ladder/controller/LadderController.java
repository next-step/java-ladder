package nextstep.ladder.controller;

import nextstep.ladder.domain.ExecutionResult;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.generator.RandomGenerator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {
	private final RandomGenerator generator;

	public LadderController(RandomGenerator generator) {
		this.generator = generator;
	}

	public void start() {
		Participants participants = InputView.scanParticipants();
		ExecutionResult executionResult = InputView.scanExecutionResult();
		Height height = InputView.scanHeightOfLadder();

		Ladder ladder = Ladder.initialize(generator, participants.size(), height.getValue());

		ResultView.printTitle();
		ResultView.printParticipants(participants.getValues());
		ResultView.printLadder(ladder.getLines());
		ResultView.printExecutionResult(executionResult.getValues());
	}
}
