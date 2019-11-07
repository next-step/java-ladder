package ladder.domain;

import ladder.domain.policy.PointConnectPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

class Line {

	private static final int MIN_POINT_INDEX = 0;
	private static final int MIN_ACTIVE_POINT_INDEX = 1;
	private static final int ADDITIONAL_POINT_INDEX = 1;
	private static final int ADDITIONAL_POINT_COUNT = 2;

	private final List<Point> points = new ArrayList<>();

	private Line(String name, int lineHeight) {
		points.add(Point.newInstance(name));
		for (int i = MIN_ACTIVE_POINT_INDEX, end = lineHeight + ADDITIONAL_POINT_COUNT; i < end; i++) {
			points.add(Point.newInstance());
		}
		connectPointsVertically();
	}

	private Line(List<Point> points) {
		this.points.addAll(points);
	}

	static Line of(String name, int lineHeight) {
		return new Line(name, lineHeight);
	}

	static Line of(List<Point> points) {
		return new Line(points);
	}

	private void connectPointsVertically() {
		for (int i = MIN_POINT_INDEX, end = getLastActivePointIndex(); i < end; i++) {
			getPoint(i).connectPointVertically(getNextPoint(i));
		}
	}

	void makeStepWithAdjacentLine(Line adjacentLine, PointConnectPolicy policy) {
		for (int i = MIN_ACTIVE_POINT_INDEX, end = getLastActivePointIndex(); i < end; i++) {
			getPoint(i).connectStepWithAdjacentPoint(adjacentLine.getPoint(i), policy);
		}
	}

	private Point getPoint(int index) {
		if (index >= points.size()) {
			throw new IllegalStateException(String.format("조회한 인덱스(%s)가 점의 개수(%s)를 초과합니다",
					index, points.size()));
		}
		return points.get(index);
	}

	private Point getNextPoint(int index) {
		return getPoint(index + ADDITIONAL_POINT_INDEX);
	}

	private int getLastActivePointIndex() {
		return points.size() - ADDITIONAL_POINT_INDEX;
	}

	String toStringOfPoint(int index) {
		return getPoint(index + ADDITIONAL_POINT_INDEX).toString();
	}

	Optional<String> getPlayerName() {
		return getPoint(MIN_POINT_INDEX).getData();
	}

	int getHeight() {
		return points.size() - ADDITIONAL_POINT_COUNT;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Line line = (Line) o;
		return Objects.equals(points, line.points);
	}

	@Override
	public int hashCode() {
		return Objects.hash(points);
	}

}
