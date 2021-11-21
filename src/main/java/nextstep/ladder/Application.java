package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.generator.RandomGenerator;
import nextstep.ladder.generator.RandomLadderGenerator;
import nextstep.ladder.service.LadderService;
import nextstep.ladder.service.LadderServiceImpl;

public class Application {
	public static void main(String[] args) {
		RandomGenerator generator = new RandomLadderGenerator();
		LadderService ladderService = new LadderServiceImpl();
		LadderController ladderController = new LadderController(generator, ladderService);
		ladderController.start();
	}
}
