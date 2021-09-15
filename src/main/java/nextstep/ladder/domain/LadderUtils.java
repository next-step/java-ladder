package nextstep.ladder.domain;

import java.util.Random;

public class LadderUtils {
	private static Random random = new Random();

	private LadderUtils() {
	}

	public static boolean makeRandomBoolean() {
		return random.nextBoolean();
	}
}