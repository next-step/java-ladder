package step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
	private final List<Point> points;

	public Line(List<Point> points) {
		this.points = points;
	}

	public static Line init(int countOfPerson) {
		List<Point> points2 = new ArrayList<>();
		Point point = initFirst(points2);
		initBody(countOfPerson, point, points2);
		return new Line(points2);
	}

	private static Point initFirst(List<Point> points) {
		Point point = Point.first();
		points.add(point);
		return point;
	}

	private static void initBody(int countOfPerson, Point point, List<Point> points) {
		for (int i = 1; i < countOfPerson; i++) {
			point = point.next();
			points.add(point);
		}
	}

	public List<Point> getPoints() {
		return Collections.unmodifiableList(points);
	}

	public boolean isPoint(int index) {
		return points.get(index).isPoint();
	}
}
