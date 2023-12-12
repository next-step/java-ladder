package nextstep.ladder.domain.strategy;

import java.util.ArrayList;
import java.util.List;

import nextstep.ladder.domain.Point;

public class MiddleLineGenerator implements LineGenerator{
	private final List<Point> beforeLine;

	public MiddleLineGenerator(List<Point> beforeLine) {
		this.beforeLine = beforeLine;
	}

	@Override
	public List<Point> generate() {
		List<Point> points = new ArrayList<>();
		for (Point point : beforeLine) {
			if (point.isRight()) {
				points.add(Point.LEFT);
				continue;
			}
			points.add(Point.random());
		}
		return points;
	}
}
