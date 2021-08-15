package ladder.domain.line;

import java.util.Random;

public class RandomBoolGenerator {

	private static final Random random = new Random();

	private RandomBoolGenerator() {
		throw new IllegalStateException();
	}

	public static Boolean generate() {
		return random.nextBoolean();
	}
}
