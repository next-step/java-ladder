package ladder.domain;

import ladder.domain.policy.PointConnectPolicy;

import java.util.*;

public class Point {

	// TODO: 2019-11-07 1급 컬렉션으로 뺄 수 있음!
	private final Map<Direction, Point> nextPoints = new HashMap<>();
	private boolean pointsMeHorizontally;
	private final String data;

	private Point(boolean pointsMeHorizontally) {
		this(Collections.emptyMap(), pointsMeHorizontally);
	}

	private Point(String data) {
		this(Collections.emptyMap(), false, data);
	}

	private Point(Map<Direction, Point> nextPoints, boolean pointsMeHorizontally) {
		this.nextPoints.putAll(nextPoints);
		this.pointsMeHorizontally = pointsMeHorizontally;
		this.data = null;
	}

	private Point(Map<Direction, Point> nextPoints, boolean pointsMeHorizontally, String data) {
		this.nextPoints.putAll(nextPoints);
		this.pointsMeHorizontally = pointsMeHorizontally;
		this.data = data;
	}

	static Point newInstance() {
		return new Point(false);
	}

	static Point newInstance(String data) {
		return new Point(data);
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

	Optional<String> getData() {
		return Optional.ofNullable(data);
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

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("|");
		addVerticalLineIfHasNextPoint(stringBuilder);
		addEmptyLineIfHasNotNextPoint(stringBuilder);
		return stringBuilder.toString();
	}

	private void addVerticalLineIfHasNextPoint(StringBuilder stringBuilder) {
		if (hasNextPoint()) {
			stringBuilder.append("-----");
		}
	}

	private void addEmptyLineIfHasNotNextPoint(StringBuilder stringBuilder) {
		if (!hasNextPoint()) {
			stringBuilder.append("     ");
		}
	}

	private boolean hasNextPoint() {
		return nextPoints.containsKey(Direction.HORIZONTAL);
	}

}
