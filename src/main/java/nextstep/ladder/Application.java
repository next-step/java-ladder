package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.converter.ResultConverter;
import nextstep.ladder.generator.RandomGenerator;
import nextstep.ladder.generator.RandomBooleanGenerator;

public class Application {
	public static void main(String[] args) {
		RandomGenerator generator = new RandomBooleanGenerator();
		ResultConverter resultConverter = new ResultConverter();
		LadderController ladderController = new LadderController(generator, resultConverter);
		ladderController.start();
	}
}
