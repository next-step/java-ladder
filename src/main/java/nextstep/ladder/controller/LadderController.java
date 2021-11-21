package nextstep.ladder.controller;

import nextstep.ladder.domain.ExecutionResult;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.dto.LadderResultDto;
import nextstep.ladder.generator.RandomGenerator;
import nextstep.ladder.service.LadderService;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {
	private final RandomGenerator generator;
	private final LadderService ladderService;

	public LadderController(RandomGenerator generator, LadderService ladderService) {
		this.generator = generator;
		this.ladderService = ladderService;
	}

	public void start() {
		Participants participants = InputView.scanParticipants();
		ExecutionResult executionResult = InputView.scanExecutionResult();
		Height height = InputView.scanHeightOfLadder();

		Ladder ladder = Ladder.initialize(generator, participants.size(), height.getValue());

		LadderResultDto resultDto = ladderService.calculateResult(ladder, participants, executionResult);

		ResultView.printTitle();
		ResultView.printParticipants(participants.getValues());
		ResultView.printLadder(ladder.getLines());
		ResultView.printExecutionResult(executionResult.getValues());

		while (true) {
			String name = InputView.scanNameForPrintResult();

			if (InputView.EXIT.equals(name)) {
				return;
			}

			ResultView.printResult(name, resultDto);
		}
	}
}
