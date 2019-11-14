package ladder.controller;

import ladder.domain.LadderExecutionResult;
import ladder.domain.LadderInput;
import ladder.domain.ladder.Ladder;
import ladder.domain.policy.PointConnectRandomly;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

	public static void start() {
		Ladder ladder = createAndPrintLadder();
		showResult(ladder.getAllResult());
	}

	private static Ladder createAndPrintLadder() {
		LadderInput ladderInput = new LadderInput(InputView.receivePeopleName(),
				InputView.receiveLadderResult());
		Ladder ladder = new  Ladder(new PointConnectRandomly(), ladderInput, InputView.receiveLadderHeight());
		ResultView.printLadder(ladder);
		return ladder;
	}

	private static void showResult(LadderExecutionResult ladder) {
		while (true) {
			String name = InputView.receivePersonNameToShowResult();
			if ("ALL".equals(name)) {
				ResultView.printAllResult(ladder);
				break;
			} else {
				ResultView.printResult(ladder.getExecutionResult(name));
			}
		}
	}

}
