package nextstep.ladder.domain;

import java.util.Random;

public class LadderDirectionGenerator {
	private static final Random random = new Random();

	private LadderDirectionGenerator() {
	}

	public static Direction makeRightOrNothing() {
		return random.nextBoolean() ? Direction.RIGHT : Direction.NOTHING;
	}
}