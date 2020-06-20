package nextstep.ladder.application;

import nextstep.ladder.application.view.InputView;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.util.painter.PaintingStrategy;

public class LadderGameService {

	private final PaintingStrategy paintingStrategy;

	public LadderGameService(PaintingStrategy paintingStrategy) {
		this.paintingStrategy = paintingStrategy;
	}

	public Ladder getLadder() {
		return Ladder.ofLadder(InputView.getPlayers(), InputView.getHeights(), paintingStrategy);
	}
}
