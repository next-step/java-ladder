package ladder.domain;

public enum Direction {

	VERTICAL,
	HORIZONTAL,
	HORIZONTAL_REVERSE;

	public boolean isVertical() {
		return this == VERTICAL;
	}

	public boolean isHorizontal() {
		return this == HORIZONTAL || this == HORIZONTAL_REVERSE;
	}

}
