package ladder.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class RandomPointGenerator implements PointGenerator {

	private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

	@Override
	public boolean point(boolean current) {
		if (current == false) {
			return RANDOM.nextBoolean();
		}
		return false;
	}
}
