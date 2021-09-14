package nextstep.ladder.domain.strategy;

import java.util.Random;

public class LineRandomStrategy implements LineStrategy {
	private static final Random RANDOM = new Random();

	@Override
	public boolean createPoint() {
		return RANDOM.nextBoolean();
	}
}