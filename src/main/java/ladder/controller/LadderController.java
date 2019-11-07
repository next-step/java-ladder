package ladder.controller;

import ladder.domain.Ladder;
import ladder.view.InputView;

public class LadderController {

	public static void start() {
		Ladder.of(() -> true, InputView.receivePeopleName(), InputView.receiveLadderHeight());
	}

}
