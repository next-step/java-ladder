package laddergame2.domain;

import java.util.Random;

public class RandomGenerator {

	private static final Random random = new Random();

	public static boolean generate() {
		return random.nextBoolean();
	}
}
