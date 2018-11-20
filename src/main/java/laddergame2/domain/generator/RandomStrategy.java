package laddergame2.domain.generator;

import java.util.Random;

public class RandomStrategy implements PointGenerationStrategy {

	private Random random = new Random();

	@Override
	public Boolean generate() {
		return random.nextBoolean();
	}
}
