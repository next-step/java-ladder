package nextstep.ladder.application;

import nextstep.ladder.application.view.OutputView;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.util.painter.PaintingStrategy;

public class LadderGameController {

	private final LadderGameService ladderGameService;

	public LadderGameController(PaintingStrategy paintingStrategy) {
		this.ladderGameService = new LadderGameService(paintingStrategy);
	}

	public void startGame() {
		Ladder ladder = ladderGameService.getLadder();
		OutputView.printLadder(ladder);
	}
}
