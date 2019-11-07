package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Point {

	// TODO: 2019-11-07 1급 컬렉션으로 뺄 수 있음!
	private final Map<Direction, Point> nextPoints = new HashMap<>();
	private boolean pointsMeHorizontally;

	private Point(boolean pointsMeHorizontally) {
		this(Collections.emptyMap(), pointsMeHorizontally);
	}

	private Point(Map<Direction, Point> nextPoints, boolean pointsMeHorizontally) {
		this.nextPoints.putAll(nextPoints);
		this.pointsMeHorizontally = pointsMeHorizontally;
	}

	static Point newInstance() {
		return new Point(false);
	}

	// Test Fixture
	public static Point of(Map<Direction, Point> nextPoints) {
		return new Point(nextPoints, false);
	}

	public static Point of(boolean pointsMeHorizontally) {
		return new Point(pointsMeHorizontally);
	}

	void connectPointVertically(Point nextPoint) {
		nextPoints.put(Direction.VERTICAL, nextPoint);
	}

	void connectStepWithAdjacentPoint(Point adjacentPoint, PointConnectPolicy policy) {
		if (canConnectStep(policy)) {
			nextPoints.put(Direction.HORIZONTAL, adjacentPoint);
			adjacentPoint.pointsMeHorizontally = true;
		}
	}

	private boolean canConnectStep(PointConnectPolicy policy) {
		return policy.shouldConnect() && !pointsMeHorizontally;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Point point = (Point) o;
		return pointsMeHorizontally == point.pointsMeHorizontally &&
				Objects.equals(nextPoints, point.nextPoints);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nextPoints, pointsMeHorizontally);
	}

}
