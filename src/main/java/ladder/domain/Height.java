package ladder.domain;

import java.util.InputMismatchException;
import java.util.Objects;

public class Height {
	private static final int MIN_COUNT = 1;
	private final int height;

	public Height(int height) {
		validate(height);
		this.height = height;
	}

	private void validate(int count) {
		if (count < MIN_COUNT) {
			throw new InputMismatchException("사다리 높이는 1개 이상이어야합니다.");
		}
	}

	public int find() {
		return height;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Height count1 = (Height)o;
		return height == count1.height;
	}

	@Override
	public int hashCode() {
		return Objects.hash(height);
	}

	@Override
	public String toString() {
		return String.valueOf(height);
	}
}
