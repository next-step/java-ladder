package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.generator.PointGenerator;
import nextstep.ladder.generator.RandomPointGenerator;

public class Application {
	public static void main(String[] args) {
		PointGenerator generator = new RandomPointGenerator();
		LadderController ladderController = new LadderController(generator);
		ladderController.start();
	}
}
