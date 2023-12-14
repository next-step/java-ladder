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
		try {
			for (int i = 0; i < points.size(); i++) {
				if (points.get(i).isLeft() && !points.get(i - 1).isRight()) {
					throw new IllegalArgumentException("수평 이동선 생성에 문제가 있습니다.");
				}
				if (points.get(i).isRight() && !points.get(i + 1).isLeft()) {
					throw new IllegalArgumentException("수평 이동선 생성에 문제가 있습니다.");
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("사다리 폭을 초과하여 이동할 수 없습니다.");
		}
	}

	public int getMovedIndex(int index) {
		return points.get(index)
			.move(index);
	}
}
