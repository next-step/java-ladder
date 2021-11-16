package nextstep.ladder.domain;

public class Height {
	private final int value;

	private Height(String value) {
		this(Integer.parseInt(value));
	}

	private Height(int value) {
		validate(value);
		this.value = value;
	}

	private void validate(int value) {
		if (value < 1) {
			throw new RuntimeException("높이는 0보다 커야 합니다.");
		}
	}

	public static Height create(String value) {
		return new Height(value);
	}

	public int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Height height = (Height)obj;

		return value == height.value;
	}

	@Override
	public int hashCode() {
		return value;
	}
}
