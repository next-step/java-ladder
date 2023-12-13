package nextstep.ladder.domain;

public class Height {
	private static final int MIN_HEIGHT = 1;
	private final int height;

	public Height(int height) {
		this.height = height;
		isOverMin();
	}

	private void isOverMin() {
		if (height < MIN_HEIGHT) {
			throw new IllegalArgumentException("사다리의 높이는 " + MIN_HEIGHT + "보다 커야합니다.");
		}
	}

	public int value() {
		return height;
	}
}
