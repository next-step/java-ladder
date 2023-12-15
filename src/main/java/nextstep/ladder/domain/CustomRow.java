package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nextstep.ladder.engine.Row;

public class CustomRow implements Row {
	private final List<Point> points;

	public CustomRow(List<Point> points) {
		this.points = points;
	}

	public CustomRow(Width width) {
		points = new ArrayList<>();
		addRandom();
		int widthValue = width.value();
		for (int i = 1; i < widthValue - 1; i++) {
			addPoint(points.get(i - 1));
		}
		addLastPoint(points.get(widthValue - 2));
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

	@Override
	public int move(int index) {
		return points.get(index)
			.move(index);
	}
}
