package step2.domain;

import java.util.Objects;

public class Height {

	private static final int MIN_HEIGHT = 1;
	private final int value;

	public Height(int input) {
		validateMin(input);
		this.value = input;
	}

	private void validateMin(int input) {
		if (input < MIN_HEIGHT) {
			throw new IllegalArgumentException("사다리의 최소 높이는 1 입니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Height height = (Height)o;
		return value == height.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
