package ladder.domain.ladder;

public class Point {
	private final boolean point;

	public Point(boolean point) {
		this.point = point;
	}

	public static Point createPoint(boolean point) {
		return new Point(point);
	}

	public boolean getPoint() {
		return point;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Point point = (Point) obj;
		return this.point == point.point;
	}

	@Override
	public int hashCode() {
		return Boolean.hashCode(point);
	}
}
