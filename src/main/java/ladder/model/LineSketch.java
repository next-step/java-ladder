package ladder.model;

import java.util.Random;

import ladder.strategy.RandomStrategy;

public class LineSketch implements RandomStrategy {

	private static final Random random = new Random();

	@Override
	public boolean drawLine() {
		return createLine();
	}

	private boolean createLine() {
		return random.nextBoolean();
	}

}
