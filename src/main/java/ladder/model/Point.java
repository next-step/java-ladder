package ladder.model;

import java.util.Objects;

public class Point {

	private final boolean direction;

	public Point(boolean direction) {
		this.direction = direction;
	}

	public int movePosition(int position, boolean rightDirection) {
		return Direction.movePosition(direction, rightDirection, position);
	}

	public boolean isDirection() {
		return direction;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Point point = (Point)o;
		return direction == point.direction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(direction);
	}
}
