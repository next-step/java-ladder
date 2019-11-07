package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.policy.PointConnectRandomly;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

	public static void start() {
		Ladder ladder = Ladder.of(new PointConnectRandomly(), InputView.receivePeopleName(),
				InputView.receiveLadderHeight());
		ResultView.printLadder(ladder);
	}

}
