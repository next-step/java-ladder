package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineFactory {

	private LineFactory() {
	}

	public static Line from(Players players) {
		List<Point> points = new ArrayList<>();
		Point point = Point.first();
		points.add(point);

		for (int i = 1; i < players.size() - 1; i++) {
			point = Point.next(point);
			points.add(point);
		}

		points.add(Point.last(point));
		return new Line(points);
	}

}
