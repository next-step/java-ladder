package ladder.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class RandomUtil {

	private static final int MAX_BOOLEAN_NUMBER = 2;

	private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

	private RandomUtil() {
	}

	public static boolean random() {
		return random(MAX_BOOLEAN_NUMBER) == 1;
	}

	private static int random(int maxNumber) {
		return RANDOM.nextInt(maxNumber);
	}
}
