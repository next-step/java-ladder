package ladder.model;

import java.util.Objects;

import ladder.message.ErrorMessage;

public class Height {

	public static final int LIMIT_HEIGHT = 0;
	private final int height;

	public Height(int height) {
		checkLimitHeight(height);
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	private void checkLimitHeight(int height) {
		if (height <= LIMIT_HEIGHT) {
			throw new IllegalArgumentException(ErrorMessage.LIMIT_HEIGHT_ERROR_MESSAGE);
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
