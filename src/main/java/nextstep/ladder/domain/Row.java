package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Row {
	private final List<Point> points;

	public Row(List<Point> points) {
		this.points = points;
		validate();
	}

	public Row(Width width) {
		points = new ArrayList<>();
		addRandom();
		for (int i = 1; i < width.value() - 1; i++) {
			addPoint(points.get(i - 1));
		}
		addLastPoint(points.get(width.value() - 2));
		validate();
	}

	public List<Point> values() {
		return Collections.unmodifiableList(points);
	}

	private void addPoint(Point beforePoint) {
		if (beforePoint.isRight()) {
			points.add(Point.LEFT);
			return;
		}
		addRandom();
	}

	private void addLastPoint(Point beforePoint) {
		if (beforePoint.isRight()) {
			points.add(Point.LEFT);
			return;
		}
		points.add(Point.HOLD);
	}

	private void addRandom() {
		points.add(Point.random());
	}

	private void validate() {
		for (int index = 0; index < points.size(); index++) {
			validateOverRange(index);
			validatePair(index);
		}
	}

	private void validateOverRange(int index) {
		if (isIndexUnderZero(index) || isIndexOverMaxSize(index)) {
			throw new IllegalArgumentException("사다리 폭을 초과하여 이동할 수 없습니다.");
		}
	}

	private boolean isIndexUnderZero(int index) {
		return points.get(index).move(index) < 0;
	}

	private boolean isIndexOverMaxSize(int index) {
		return points.get(index).move(index) >= points.size();
	}

	private void validatePair(int index) {
		if (
			points.get(index).isLeft() && !points.get(index - 1).isRight()
				||
				points.get(index).isRight() && !points.get(index + 1).isLeft()
		) {
			throw new IllegalArgumentException("수평 이동선 생성에 문제가 있습니다.");
		}
	}

	public int getMovedIndex(int index) {
		return points.get(index)
			.move(index);
	}
}
