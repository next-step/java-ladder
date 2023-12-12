package nextstep.ladder.domain.strategy;

import java.util.ArrayList;
import java.util.List;

import nextstep.ladder.domain.Point;

public class LastLineGenerator implements LineGenerator{
	private final List<Point> beforeLine;

	public LastLineGenerator(List<Point> beforeLine) {
		this.beforeLine = beforeLine;
	}

	@Override
	public List<Point> generate() {
		List<Point> points = new ArrayList<>();
		for (Point point : beforeLine) {
			// indent 개선
			if (point.isRight()) {
				points.add(Point.LEFT);
				continue;
			}
			points.add(Point.DOWN);
		}
		return points;
	}
}
