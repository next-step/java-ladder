package nextstep.ladder.domain;

public class Height {
	private final int value;

	public Height(int value) {
		if (value <= 0) {
			throw new IllegalArgumentException("Height must be a positive integer.");
		}
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
