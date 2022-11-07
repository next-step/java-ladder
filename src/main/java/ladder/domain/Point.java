package ladder.domain;

import java.util.Objects;
import java.util.function.BooleanSupplier;

/**
 * Created by seungwoo.song on 2022-11-01
 */
public class Point {

	private final int index;
	private final Direction direction;

	public Point(int index, Direction direction) {
		if (index < 0) {
			throw new IllegalArgumentException("0이하는 입력할 수 없습니다");
		}

		this.index = index;
		this.direction = direction;
	}

	public static Point first(boolean right) {
		return Point.of(0, Direction.first(right));
	}

	public static Point of(int index, Direction direction) {
		return new Point(index, direction);
	}

	public Point next(boolean right) {
		return of(nextIndex(), direction.next(() -> right));
	}

	public Point next(BooleanSupplier booleanSupplier) {
		return of(nextIndex(), direction.next(booleanSupplier));
	}

	public Point last() {
		return of(nextIndex(), direction.last());
	}

	private int nextIndex() {
		return index + 1;
	}

	public int move() {
		if (direction.isLeft()) {
			return index - 1;
		}

		if (direction.isRight()) {
			return index + 1;
		}

		return index;
	}

	public boolean isMark() {
		return direction.isRight();
	}

	// =============================================================================================

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Point point = (Point)o;
		return index == point.index && direction == point.direction;
	}

	@Override public int hashCode() {
		return Objects.hash(index, direction);
	}

	@Override public String toString() {
		return "Point{" + "index=" + index + ", direction=" + direction + '}';
	}
}
