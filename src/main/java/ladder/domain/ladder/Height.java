package ladder.domain.ladder;

public class Height {
	private final int height;

	private Height(int height) {
		this.height = height;
	}

	public static Height createHeight(int height) {
		if (height < 1) {
			throw new IllegalArgumentException("높이는 1 이상이어야 합니다.");
		}
		return new Height(height);
	}

	public int getHeight() {
		return height;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Height height = (Height) obj;
		return this.height == height.height;
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(height);
	}
}
