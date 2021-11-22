package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
	private final Direction direction;

	private Point(Direction direction) {
		this.direction = direction;
	}

	public static Point create(boolean left, boolean right) {
		return new Point(Direction.create(left, right));
	}

	public static Point createFirstOfLine(boolean right) {
		return create(false, right);
	}

	public static Point createLastOfLine(boolean isPrevPointHasRightLine) {
		return create(isPrevPointHasRightLine, false);
	}

	public boolean isDirectionLeft() {
		return direction.isLeft();
	}

	public boolean isDirectionRight() {
		return direction.isRight();
	}

	public int move(int index) {
		return direction.move(index);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Point point = (Point)obj;

		return Objects.equals(direction, point.direction);
	}

	@Override
	public int hashCode() {
		return Objects.hash(direction);
	}

	@Override
	public String toString() {
		return "Point{" +
			"direction=" + direction +
			'}';
	}
}
