package ladder.util;

import java.util.Random;

public final class RandomPointGenerator implements PointGenerator {
	private static final Random RANDOM = new Random();

	@Override
	public boolean generate() {
		return RANDOM.nextBoolean();
	}
}
