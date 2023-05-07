package ladder.domain;

import java.util.Objects;

public class Height {

	private static final int HEIGHT_MINIMUM = 1;

	private final int height;

	public Height(int height) {
		if (height < Height.HEIGHT_MINIMUM) {
			throw new IllegalArgumentException(String.format("사다리 높이는 최소 %d입니다. 입력값: %d", Height.HEIGHT_MINIMUM, height));
		}
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Height height1 = (Height)o;
		return height == height1.height;
	}

	@Override
	public int hashCode() {
		return Objects.hash(height);
	}
}
