package ladder.controller;

import ladder.domain.Participants;
import ladder.domain.ladder.Ladder;
import ladder.domain.policy.PointConnectRandomly;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

	public static void start() {
		Ladder ladder = new Ladder(new PointConnectRandomly(), new Participants(InputView.receivePeopleName()),
				InputView.receiveLadderHeight());
		ResultView.printLadder(ladder);
	}

}
