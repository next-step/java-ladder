package nextstep.step4.domain;

import java.util.ArrayList;
import java.util.List;

import nextstep.step4.util.RandomDirectionFactory;

public class LineFactory {

	private LineFactory() {
	}

	public static Line from(Players players) {
		List<Point> points = new ArrayList<>();
		Point point = Point.first(RandomDirectionFactory.generate());
		points.add(point);

		for (int i = 1; i < players.size() - 1; i++) {
			point = point.next(RandomDirectionFactory.generate());
			points.add(point);
		}

		points.add(point.last());
		return new Line(points);
	}

}
