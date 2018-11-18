package domain;

/**
 * Created by hspark on 18/11/2018.
 */
public class Point {
	private int point;

	public Point(int point) {
		this.point = point;
	}

	public int getInteger() {
		return point;
	}

	public boolean isAdjacent(Point other) {
		return Math.abs(point - other.point) == 1;
	}

	public int getDiff(Point other) {
		return point - other.point;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Point point1 = (Point) o;

		return point == point1.point;
	}

	@Override
	public int hashCode() {
		return point;
	}
}
