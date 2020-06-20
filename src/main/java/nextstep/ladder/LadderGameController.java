package nextstep.ladder;

import nextstep.ladder.ladder.Ladder;
import nextstep.ladder.painter.PaintingStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

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
