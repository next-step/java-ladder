package step2.domain.ladder;

import java.util.Objects;

import step2.util.Validator;

public class Height {

	private static final int MIN_HEIGHT = 1;
	private final int value;

	public Height(int height) {
		Validator.min(MIN_HEIGHT, height, String.format("사다리의 최소 높이는 %d 입니다. 입력 : %d", MIN_HEIGHT, height));
		this.value = height;
	}

	public int getValue() {
		return value;
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
