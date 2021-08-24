package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import nextstep.ladder.exception.InvalidFirstPointException;
import nextstep.ladder.exception.InvalidLastPointException;
import nextstep.ladder.exception.InvalidMidPointException;

public class Line {

	private final List<Point> points;

	public Line(List<Point> points) {
		validatePoints(points);
		this.points = new ArrayList<>(points);
	}

	public List<Point> points() {
		return Collections.unmodifiableList(points);
	}

	private void validatePoints(List<Point> points) {
		Point first = points.get(0);
		validateFirstPoint(first);

		Point current = first;
		for (int i = 1; i < points.size() - 1; i++) {
			Point next = points.get(i);
			validateMidPoint(current, next);
			current = next;
		}

		Point last = points.get(points.size() - 1);
		validateLastPoint(last);
	}

	private void validateLastPoint(Point last) {
		if (last.isRightward()) {
			throw new InvalidLastPointException();
		}
	}

	private void validateMidPoint(Point current, Point next) {
		if (current.isRightward() && !next.isLeftward()
				|| current.isLeftward() && next.isLeftward()
				|| current.isDownward() && next.isLeftward()) {
			throw new InvalidMidPointException(current, next);
		}
	}

	private void validateFirstPoint(Point first) {
		if (first.isLeftward()) {
			throw new InvalidFirstPointException();
		}
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
