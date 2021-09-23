package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.strategy.LineRandomStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {
	private final InputView inputView = new InputView();
	private final ResultView resultView = new ResultView();

	public void start() {
		Players players = new Players(inputView.inputNames());
		int ladderHeight = inputView.inputLadderHeight();
		Ladder ladder = new Ladder(players.count(), ladderHeight, new LineRandomStrategy());
		resultView.viewPlayers(players);
		resultView.viewLadder(ladder);
	}
}