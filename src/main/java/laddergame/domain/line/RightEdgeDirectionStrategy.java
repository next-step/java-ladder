package laddergame.domain.line;

public class RightEdgeDirectionStrategy implements RandomDirectionStrategy {

	private static RightEdgeDirectionStrategy instance;

	private RightEdgeDirectionStrategy() {}

	public static RightEdgeDirectionStrategy getInstance() {
		if (instance == null) {
			instance = new RightEdgeDirectionStrategy();
		}
		return instance;
	}

	@Override
	public int random() {
		// -1, 0 반환
		return RandomDirectionStrategy.random.nextInt(2) - 1;
	}
}
