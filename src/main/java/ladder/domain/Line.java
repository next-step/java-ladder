package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Line {

	private static final int MIN_POINT_INDEX = 0;
	private static final int MIN_ACTIVE_POINT_INDEX = 1;
	private static final int ADDITIONAL_POINT_COUNT = 2;

	private final List<Point> points = new ArrayList<>();

	private Line(int lineHeight) {
		for (int i = 0, end = lineHeight + ADDITIONAL_POINT_COUNT; i < end; i++) {
			points.add(Point.newInstance());
		}
		connectPointsVertically();
	}

	private Line(List<Point> points) {
		this.points.addAll(points);
	}

	static Line of(int lineHeight) {
		return new Line(lineHeight);
	}

	static Line of(List<Point> points) {
		return new Line(points);
	}

	private void connectPointsVertically() {
		for (int i = MIN_POINT_INDEX, end = getLastEmptyPointIndex(); i < end; i++) {
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
		return getPoint(index + 1);
	}

	private int getLastEmptyPointIndex() {
		return points.size() - 1;
	}

	private int getLastActivePointIndex() {
		return points.size() - 2;
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

	public List<Point> getPointsCount() {
		return points;
	}

}
