package laddergame.domain.line;

import laddergame.domain.coordinate.Coordinate;
import laddergame.domain.point.Point;
import laddergame.exception.LadderGameException;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {

	private static final String INVALID_LADDER_COORDINATE = "사다리 좌표가 잘못 입력됐습니다.";
	private static final int START_INDEX = 0;

	private final LinkedList<Point> points;

	Line() {
		this.points = new LinkedList<>();
	}

	//ForTest
	Line(LinkedList<Point> points) {
		validatePoints(points);
		this.points = points;
	}

	public boolean addPoint(Point point) {
		if(!points.isEmpty()) {
			validateWithNextPoint(points.getLast(), point);
		}
		return points.add(point);
	}

	public Point getLastPoint() {
		return points.getLast();
	}

	public LinkedList<Point> getPoints() {
		return points;
	}

	public Coordinate getNextLineCoordinate(Coordinate coordinate) {
		return points.get(coordinate.getCoordinate())
					.goNextPoint();
	}

	private void validatePoints(List<Point> points) {
		Point now = points.get(START_INDEX);

		for (int i = 1 ; i < points.size() ; i ++) {
			Point next = points.get(i);
			validateWithNextPoint(now, next);
			now = next;
		}
	}

	private void validateWithNextPoint(Point now, Point next) {
		if(now.isRightDirection() && !next.isLeftDirection()) {
			throw new LadderGameException(INVALID_LADDER_COORDINATE);
		}
		if(!now.isRightDirection() && next.isLeftDirection()) {
			throw new LadderGameException(INVALID_LADDER_COORDINATE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Line line = (Line) o;
		return points.equals(line.points);
	}

	@Override
	public int hashCode() {
		return Objects.hash(points);
	}
}
