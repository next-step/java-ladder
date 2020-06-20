package nextstep.ladder.application;

import nextstep.ladder.application.prize.Prizes;
import nextstep.ladder.application.result.GameResult;
import nextstep.ladder.domain.height.Height;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.util.painter.PaintingStrategy;

public class LadderGame {

	private final PaintingStrategy paintingStrategy;
	private Ladder ladder;

	public LadderGame(PaintingStrategy paintingStrategy) {
		this.paintingStrategy = paintingStrategy;
	}

	public Ladder start(Players players, Height height) {
		this.ladder = Ladder.ofLadder(players, height, paintingStrategy);
		return this.ladder;
	}

	public GameResult play(Prizes prizes) {
		Players players = this.ladder.determinePlayersPositionResult();
		return GameResult.ofPlayersAndPrizes(players, prizes);
	}
}
