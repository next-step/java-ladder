package nextstep.ladder;

import nextstep.ladder.painter.RandomPaintingStrategy;

public class NextStepLadderGameApplication {

	public static void main(String[] args) {
		RandomPaintingStrategy randomPaintingStrategy = new RandomPaintingStrategy();
		LadderGameController ladderGameController = new LadderGameController(randomPaintingStrategy);
		ladderGameController.startGame();
	}
}
