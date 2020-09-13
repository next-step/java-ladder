package step4.domain;

import java.util.List;
import java.util.Random;

public class PointCreator {
	private static final Random RANDOM = new Random();

	private PointCreator() {}

	public static boolean createPoint(List<Boolean> points) {
		if (points.lastIndexOf(true) == points.size() - 1) {
			return false;
		}
		return RANDOM.nextBoolean();
	}
}
