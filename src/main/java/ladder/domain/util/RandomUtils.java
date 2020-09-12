package ladder.domain.util;

import java.util.Random;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RandomUtils {

	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 2;
	private static final Random RANDOM = new Random();

	public static boolean booleanValue() {
		return RANDOM.nextInt(MAX_VALUE) == MIN_VALUE;
	}

	public static boolean generatePoint() {
		return booleanValue();
	}

	public static int intValue(int maxValue) {
		return RANDOM.nextInt(maxValue);
	}

}
