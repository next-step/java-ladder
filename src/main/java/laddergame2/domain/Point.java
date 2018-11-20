package laddergame2.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Point {

	private static final Map<String, Point> cache = new HashMap<>();

	private static final int START_INDEX = 0;
	private static final int CALCULATION_INDEX = 1;

	private final int index;
	private final Direction direction;

	private Point(int index, Direction direction) {
		this.index = index;
		this.direction = direction;
	}

	public static Point first(Boolean right) {
		return Point.of(START_INDEX, Direction.first(right));
	}

	public static Point of(int index, Direction direction) {
		String key = String.format("%d_%s", index, direction);
		if (cache.containsKey(key)) {
			return cache.get(key);
		}
		Point point = new Point(index, direction);
		cache.put(key, point);
		return point;
	}

	public Point next() {
		return Point.of(index + CALCULATION_INDEX, direction.next());
	}

	public Point last() {
		return Point.of(index + CALCULATION_INDEX, direction.last());
	}

	public int move() {
		if (Direction.LEFT.equals(direction)) {
			return index - CALCULATION_INDEX;
		}
		if (Direction.RIGHT.equals(direction)) {
			return index + CALCULATION_INDEX;
		}
		return index;
	}

	public boolean isLeft() {
		return direction.equals(Direction.LEFT);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Point)) {
			return false;
		}
		Point point = (Point) o;
		return index == point.index &&
				Objects.equals(direction, point.direction);
	}

	@Override
	public int hashCode() {
		return Objects.hash(index, direction);
	}

	@Override
	public String toString() {
		return "Point{" +
				"index=" + index +
				", direction=" + direction +
				'}';
	}
}
