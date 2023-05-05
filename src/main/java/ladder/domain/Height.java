package ladder.domain;

public class Height {

	private static final int HEIGHT_MINIMUM = 1;

	private final int height;

	public Height(int height) {
		if (height < Height.HEIGHT_MINIMUM) {
			throw new IllegalArgumentException(String.format("사다리 높이는 최소 %d입니다. 입력값: %d", Height.HEIGHT_MINIMUM, height));
		}
		this.height = height;
	}
}
