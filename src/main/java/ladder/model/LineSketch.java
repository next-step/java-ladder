package ladder.model;

import java.util.Random;

public class LineSketch {

	private static final Random random = new Random();

	public static boolean drawLine(boolean prevDirection) {
		if (prevDirection) {
			return false;
		}
		return random.nextBoolean();
	}
}
