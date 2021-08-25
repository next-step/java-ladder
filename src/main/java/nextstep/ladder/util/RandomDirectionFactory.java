package nextstep.ladder.util;

import java.util.Random;

public class RandomDirectionFactory {

	private static final Random RANDOM = new Random();

	private RandomDirectionFactory() {
	}

	public static boolean generate() {
		return RANDOM.nextBoolean();
	}
}
