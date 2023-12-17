package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nextstep.ladder.domain.strategy.RandomPointGenerateStrategy;
import nextstep.ladder.engine.Row;
import nextstep.ladder.engine.strategy.PointGenerateStrategy;

public class CustomRow implements Row {
	private final List<Point> points;

	public CustomRow(List<Point> points) {
		this.points = points;
	}

	public CustomRow(Width width) {
		points = new ArrayList<>();

		PointGenerateStrategy strategy = new RandomPointGenerateStrategy();

		addPoint(strategy);
		int widthValue = width.value();
		for (int i = 1; i < widthValue - 1; i++) {
			addPoint(points.get(i - 1), strategy);
		}
		addLastPoint(points.get(widthValue - 2));
	}

	public List<Point> values() {
		return Collections.unmodifiableList(points);
	}

	private void addPoint(Point beforePoint, PointGenerateStrategy strategy) {
		if (beforePoint.isRight()) {
			points.add(Point.LEFT);
			return;
		}
		addPoint(strategy);
	}

	private void addLastPoint(Point beforePoint) {
		if (beforePoint.isRight()) {
			points.add(Point.LEFT);
			return;
		}
		points.add(Point.HOLD);
	}

	private void addPoint(PointGenerateStrategy strategy) {
		points.add(strategy.generate());
	}

	@Override
	public int move(int index) {
		return points.get(index)
			.move(index);
	}
}
