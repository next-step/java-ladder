package ladder.controller;

import ladder.domain.LadderInput;
import ladder.domain.ladder.Ladder;
import ladder.domain.policy.PointConnectRandomly;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

	public static void start() {
		LadderInput ladderInput = new LadderInput(InputView.receivePeopleName(),
				InputView.receiveLadderResult());
		Ladder ladder = new Ladder(new PointConnectRandomly(), ladderInput, InputView.receiveLadderHeight());
		ResultView.printLadder(ladder);
	}

}
