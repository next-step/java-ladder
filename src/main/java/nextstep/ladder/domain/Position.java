package nextstep.ladder.domain;

import java.util.Objects;

public class Position {
	public static final String NEGATIVE_NUMBER_IS_NOT_VALIED = "좌표값은 음수가 될 수 없습니다.";
	private final int positon;

	public Position(int positon) {
		validate(positon);
		this.positon = positon;
	}

	private void validate(int positon) {
		if(positon < 0) {
			throw new IllegalArgumentException(NEGATIVE_NUMBER_IS_NOT_VALIED);
		}
	}

	public Position move(int distance) {
		return new Position(positon + distance);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Position position = (Position)o;
		return positon == position.positon;
	}

	@Override
	public int hashCode() {
		return Objects.hash(positon);
	}
}
