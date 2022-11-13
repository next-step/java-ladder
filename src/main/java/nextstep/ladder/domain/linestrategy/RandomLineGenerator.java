package nextstep.ladder.domain.linestrategy;

import java.util.Random;

public class RandomLineGenerator implements LineGenerator {

	private static final Random RANDOM = new Random();

	@Override
	public Boolean generatePoint() {
		return generateRandomBoolean();
	}

	private Boolean generateRandomBoolean() {
		return RANDOM.nextBoolean();
	}
}