package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.generator.RandomGenerator;
import nextstep.ladder.generator.RandomLadderGenerator;

public class Application {
	public static void main(String[] args) {
		RandomGenerator generator = new RandomLadderGenerator();
		LadderController ladderController = new LadderController(generator);
		ladderController.start();
	}
}
