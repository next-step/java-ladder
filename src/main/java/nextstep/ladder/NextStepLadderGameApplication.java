package nextstep.ladder;

import nextstep.ladder.game.LadderGameController;
import nextstep.ladder.painter.RandomPaintingStrategyImpl;

public class NextStepLadderGameApplication {

	public static void main(String[] args) {
		RandomPaintingStrategyImpl randomPaintingStrategy = new RandomPaintingStrategyImpl();
		LadderGameController ladderGameController = new LadderGameController(randomPaintingStrategy);
		ladderGameController.startGame();
	}
}
