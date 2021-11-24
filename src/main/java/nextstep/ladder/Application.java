package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.converter.ResultConverter;
import nextstep.ladder.generator.Generator;
import nextstep.ladder.generator.RandomGenerator;

public class Application {
	public static void main(String[] args) {
		Generator generator = new RandomGenerator();
		ResultConverter resultConverter = new ResultConverter();
		LadderController ladderController = new LadderController(generator, resultConverter);
		ladderController.start();
	}
}
