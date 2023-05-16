package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import ladder.strategy.PointGenerator;
import ladder.type.DirectionType;

public class Point {

	private static final Map<String, Point> pointMap = new HashMap<>();

	private final boolean left;
	private final boolean current;

	static {
		pointMap.put("false,false", new Point(false, false));
		pointMap.put("false,true", new Point(false, true));
		pointMap.put("true,false", new Point(true, false));
	}

	private static Point of(boolean left, boolean current) {
		if (left && current) {
			throw new IllegalArgumentException("인접한 좌표를 모두 채울 수 없습니다.");
		}
		return pointMap.get(left + "," + current);
	}

	private Point(boolean left, boolean current) {
		this.left = left;
		this.current = current;
	}

	public static Point first(boolean current) {
		return Point.of(false, current);
	}

	public Point next(boolean current) {
		return Point.of(this.current, current);
	}

	public Point last() {
		return Point.of(this.current, false);
	}

	public DirectionType direction() {
		return DirectionType.of(this);
	}

	public boolean nextPoint(PointGenerator pointGenerator) {
		boolean nextPoint = false;
		if (this.isCurrent() == false) {
			nextPoint = pointGenerator.point();
		}
		return nextPoint;
	}

	public boolean isCurrent() {
		return this.current;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Point point = (Point)o;
		return left == point.left && current == point.current;
	}

	@Override
	public int hashCode() {
		return Objects.hash(left, current);
	}
}
