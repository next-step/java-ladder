package ladder.domain;

import ladder.domain.policy.PointConnectPolicy;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class Point {

	private PointRelation pointRelation;
	private final String data;

	private Point(boolean pointsMeHorizontally) {
		this(Collections.emptyMap(), pointsMeHorizontally);
	}

	private Point(String data) {
		this(Collections.emptyMap(), false, data);
	}

	private Point(Map<Direction, Point> nextPoints, boolean pointsMeHorizontally) {
		this(nextPoints, pointsMeHorizontally, null);
	}

	private Point(Map<Direction, Point> nextPoints, boolean pointsMeHorizontally, String data) {
		this.pointRelation = PointRelation.of(nextPoints, pointsMeHorizontally);
		this.data = data;
	}

	static Point newInstance() {
		return new Point(false);
	}

	static Point newInstance(String data) {
		return new Point(data);
	}

	public static Point of(Map<Direction, Point> nextPoints) {
		return new Point(nextPoints, false);
	}

	public static Point of(boolean pointsMeHorizontally) {
		return new Point(pointsMeHorizontally);
	}

	void connectPointVertically(Point nextPoint) {
		pointRelation.addVerticalRelation(nextPoint);
	}

	void connectStepWithAdjacentPoint(Point adjacentPoint, PointConnectPolicy policy) {
		pointRelation.addHorizontalRelationIfPossible(adjacentPoint, policy);
	}

	void points() {
		pointRelation.points();
	}

	Optional<String> getData() {
		return Optional.ofNullable(data);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Point point = (Point) o;
		return Objects.equals(pointRelation, point.pointRelation) &&
				Objects.equals(data, point.data);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pointRelation, data);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("|");
		addVerticalLineIfHasNextPoint(stringBuilder);
		addEmptyLineIfHasNotNextPoint(stringBuilder);
		return stringBuilder.toString();
	}

	private void addVerticalLineIfHasNextPoint(StringBuilder stringBuilder) {
		if (hasNextHorizontalPoint()) {
			stringBuilder.append("-----");
		}
	}

	private void addEmptyLineIfHasNotNextPoint(StringBuilder stringBuilder) {
		if (!hasNextHorizontalPoint()) {
			stringBuilder.append("     ");
		}
	}

	private boolean hasNextHorizontalPoint() {
		return pointRelation.hasNextHorizontalPoint();
	}

}
