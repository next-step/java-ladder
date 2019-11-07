package ladder.domain;

import ladder.domain.policy.PointConnectPolicy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class PointRelation {

	private final Map<Direction, Point> nextPoints = new HashMap<>();
	private boolean pointsMeHorizontally;

	private PointRelation(Map<Direction, Point> nextPoints, boolean pointsMeHorizontally) {
		this.nextPoints.putAll(nextPoints);
		this.pointsMeHorizontally = pointsMeHorizontally;
	}

	public static PointRelation of(Map<Direction, Point> nextPoints, boolean pointsMeHorizontally) {
		return new PointRelation(nextPoints, pointsMeHorizontally);
	}

	void addVerticalRelation(Point nextPoint) {
		nextPoints.put(Direction.VERTICAL, nextPoint);
	}

	void addHorizontalRelationIfPossible(Point adjacentPoint, PointConnectPolicy policy) {
		if (canConnectStep(policy)) {
			nextPoints.put(Direction.HORIZONTAL, adjacentPoint);
			adjacentPoint.points();
		}
	}

	void points() {
		pointsMeHorizontally = true;
	}

	private boolean canConnectStep(PointConnectPolicy policy) {
		return policy.shouldConnect() && !pointsMeHorizontally;
	}

	boolean hasNextHorizontalPoint() {
		return nextPoints.containsKey(Direction.HORIZONTAL);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PointRelation that = (PointRelation) o;
		return pointsMeHorizontally == that.pointsMeHorizontally &&
				Objects.equals(nextPoints, that.nextPoints);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nextPoints, pointsMeHorizontally);
	}

}
