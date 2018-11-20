package laddergame2.domain.generator;

import java.util.Random;

public class ComplexityStrategy implements PointGenerationStrategy {

	private static final double MAX_GENERATION_PERCENT = 100;

	private Random random = new Random();
	private Complexity complexity;

	public ComplexityStrategy(Complexity complexity) {
		this.complexity = complexity;
	}

	@Override
	public Boolean generate() {
		final double randomPercent = random.nextDouble() * MAX_GENERATION_PERCENT;
		return complexity.canGenerate(randomPercent);
	}
}
