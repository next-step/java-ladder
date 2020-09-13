package step4.domain;

import static step4.domain.PointCreator.createPoint;

public class Point {
	private final boolean point;

	public Point(boolean point) {
		this.point = point;
	}

	public static Point first() {
		return new Point(false);
	}

	public Point next(boolean next) {
		return new Point(next);
	}

	public Point next() {
		if (point) {
			return next(false);
		}
		return next(createPoint());
	}

	public boolean isPoint() {
		return point;
	}
}
