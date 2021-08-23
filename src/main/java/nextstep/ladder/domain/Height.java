package nextstep.ladder.domain;

import java.util.Objects;

import nextstep.ladder.exception.InvalidHeightException;

public class Height {

	private static final int MIN_VALUE = 1;

	private final int height;

	public Height(int height) {
		validateHeight(height);
		this.height = height;
	}

	public int value() {
		return height;
	}

	private void validateHeight(int height) {
		if (height < MIN_VALUE) {
			throw new InvalidHeightException(height);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Height height1 = (Height)o;
		return height == height1.height;
	}

	@Override
	public int hashCode() {
		return Objects.hash(height);
	}
}
