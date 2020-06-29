package nextstep.ladder.application;

import nextstep.ladder.application.prize.Prizes;
import nextstep.ladder.application.result.GameResult;
import nextstep.ladder.application.view.InputView;
import nextstep.ladder.application.view.OutputView;
import nextstep.ladder.domain.height.Height;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.util.painter.PaintingStrategy;

public class LadderGameController {

	private final LadderGame ladderGame;

	public LadderGameController(PaintingStrategy paintingStrategy) {
		this.ladderGame = new LadderGame(paintingStrategy);
	}

	public void startGame() {
		Players players = InputView.getPlayers();
		Height height = InputView.getHeights();
		Prizes prizes = InputView.askPrizes();
		Ladder ladder = ladderGame.start(players, height);
		GameResult gameResult = ladderGame.play(prizes);
		OutputView.printLadder(ladder);
		OutputView.printPrizes(prizes);
		OutputView.printPlayerResult(gameResult, players);
	}
}
