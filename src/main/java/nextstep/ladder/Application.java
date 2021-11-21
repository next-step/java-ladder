package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.generator.RandomGenerator;
import nextstep.ladder.generator.RandomLadderGenerator;
import nextstep.ladder.converter.ResultConverter;

public class Application {
	public static void main(String[] args) {
		RandomGenerator generator = new RandomLadderGenerator();
		ResultConverter resultConverter = new ResultConverter();
		LadderController ladderController = new LadderController(generator, resultConverter);
		ladderController.start();
	}
}
