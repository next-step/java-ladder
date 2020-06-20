package nextstep.ladder.game;

import nextstep.ladder.ladder.Ladder;
import nextstep.ladder.painter.PaintingStrategy;

public class LadderGameController {

	private final PaintingStrategy paintingStrategy;

	public LadderGameController(PaintingStrategy paintingStrategy) {
		this.paintingStrategy = paintingStrategy;
	}

	public void startGame() {
		Ladder ladder = Ladder.ofLadder(InputView.getPlayers(), InputView.getHeights(), paintingStrategy);
		OutputView.printLadder(ladder);
	}
}
