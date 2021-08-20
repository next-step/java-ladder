package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {

	private final List<Point> points;

	public Line(List<Point> points) {
		this.points = Collections.unmodifiableList(points);
	}

	public static Line createLine(int playerCount) {
		List<Point> points = new ArrayList<>();
		Point point = initFirst(points);
		point = initBody(playerCount, points, point);
		initLast(points, point);
		return new Line(points);
	}

	private static Point initFirst(List<Point> points) {
		Point point = Point.initCreate(LineSketch.drawLine());
		points.add(point);
		return point;
	}

	private static Point initBody(int playerCount, List<Point> points, Point point) {
		for (int i = 1; i < playerCount - 1; i++) {
			point = point.next();
			points.add(point);
		}
		return point;
	}

	private static void initLast(List<Point> points, Point point) {
		points.add(point.initLast());
	}

	public List<Point> getPoints() {
		return points;
	}

	public int move(int position) {
		return points.get(position).movePosition(position);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Line line = (Line)o;
		return Objects.equals(points, line.points);
	}

	@Override
	public int hashCode() {
		return Objects.hash(points);
	}
}
