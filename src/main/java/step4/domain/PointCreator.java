package step4.domain;

import java.util.Random;

public class PointCreator {
	private static final Random RANDOM = new Random();

	private PointCreator() {}

	public static boolean createPoint() {
		return RANDOM.nextBoolean();
	}
}
