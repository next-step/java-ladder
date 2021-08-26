package nextstep.step4.domain;

import java.util.Objects;

import nextstep.step4.exception.InvalidHeightException;

public class Height {

	private static final int MIN_VALUE = 1;

	private final int value;

	public Height(int value) {
		validateHeight(value);
		this.value = value;
	}

	private void validateHeight(int value) {
		if (value < MIN_VALUE) {
			throw new InvalidHeightException(value);
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
