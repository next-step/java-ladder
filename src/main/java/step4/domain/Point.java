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
		if (point && next) {
			throw new IllegalArgumentException("사다리 점은 연속해서 배치할 수 없습니다.");
		}
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

	@Override
	public String toString() {
		return "Point{" +
				"point=" + point +
				'}';
	}
}
