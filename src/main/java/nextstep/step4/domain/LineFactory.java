package nextstep.step4.domain;

import java.util.ArrayList;
import java.util.List;

import nextstep.step4.util.RandomDirectionFactory;

public class LineFactory {

	private static final int SINGLE_POSITION = 1;

	private LineFactory() {
	}

	public static Line from(Players players) {
		List<Point> points = new ArrayList<>();
		Point point = Point.first(RandomDirectionFactory.generate());
		points.add(point);

		for (int position = SINGLE_POSITION; position < players.size() - SINGLE_POSITION; position++) {
			point = point.next(RandomDirectionFactory.generate());
			points.add(point);
		}

		points.add(point.last());
		return new Line(points);
	}

}
