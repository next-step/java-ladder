package ladder.util;

import java.util.Random;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class RandomUtil {

	private static final int MAX_BOOLEAN_NUMBER = 1;

	private static final Random RANDOM = new Random();

	private RandomUtil() {
	}

	public static boolean random() {
		return random(MAX_BOOLEAN_NUMBER) == 0;
	}

	private static int random(int maxNumber) {
		return RANDOM.nextInt(maxNumber);
	}
}
