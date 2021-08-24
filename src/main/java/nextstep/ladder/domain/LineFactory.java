package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

import nextstep.ladder.util.RandomDirectionFactory;

public class LineFactory {

	private LineFactory() {
	}

	public static Line from(Players players) {
		List<Point> points = new ArrayList<>();
		Point point = Point.first(RandomDirectionFactory.generate());
		points.add(point);

		for (int i = 1; i < players.size() - 1; i++) {
			point = Point.next(point, RandomDirectionFactory.generate());
			points.add(point);
		}

		points.add(Point.last(point));
		return new Line(points);
	}

}
