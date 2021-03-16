package nextstep.ladder.controller;

import nextstep.ladder.entity.Ladder;
import nextstep.ladder.entity.Users;
import nextstep.ladder.views.InputView;
import nextstep.ladder.views.OutputView;

public class LadderGameController {
	private final InputView inputView;
	private final OutputView outputView;

	public LadderGameController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void run(){
		String name = inputView.getUserName();
		Users users = new Users(name);

		int ladderHeight = inputView.getLadderHeight();

		Ladder ladder = new Ladder(users, ladderHeight);
		outputView.showResult(ladder);
	}
}
