package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Point {

	private static final Map<Boolean, Point> pointMap = new HashMap<>();

	private final boolean point;

	static {
		pointMap.put(true, new Point(true));
		pointMap.put(false, new Point(false));
	}

	private Point(boolean point) {
		this.point = point;
	}

	public static Point of(boolean point) {
		return pointMap.get(point);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Point point1 = (Point)o;
		return point == point1.point;
	}

	@Override
	public int hashCode() {
		return Objects.hash(point);
	}
}
