package ladder.model;

import java.util.Objects;

import ladder.dto.HeightDto;
import ladder.message.ErrorMessage;

public class Height {

	public static final int LIMIT_HEIGHT = 0;
	private final int height;

	public Height(int height) {
		checkLimitHeight(height);
		this.height = height;
	}

	public int getHeight() {
		return HeightDto.of(height).value();
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
		Height that = (Height)o;
		return height == that.height;
	}

	@Override
	public int hashCode() {
		return Objects.hash(height);
	}
}
