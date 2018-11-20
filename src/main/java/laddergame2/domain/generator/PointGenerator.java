package laddergame2.domain.generator;

public class PointGenerator {

	private static PointGenerator instance;

	private PointGenerationStrategy pointGenerationStrategy;

	private PointGenerator(PointGenerationStrategy pointGenerationStrategy) {
		this.pointGenerationStrategy = pointGenerationStrategy;
	}

	public static PointGenerator getInstance() {
		if (instance == null) {
			instance = newInstance(new RandomStrategy());
		}
		return instance;
	}

	public static PointGenerator newInstance(PointGenerationStrategy pointGenerationStrategy) {
		return new PointGenerator(pointGenerationStrategy);
	}

	public Boolean generate() {
		return pointGenerationStrategy.generate();
	}
}
