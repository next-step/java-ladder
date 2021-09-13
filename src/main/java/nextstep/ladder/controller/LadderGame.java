package nextstep.ladder.controller;

import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;

public class LadderGame {
	private final InputView inputView = new InputView();

	public void start() {
		Players players = new Players(inputView.inputNames());
		int ladderHeight = inputView.inputLadderHeight();
	}
}