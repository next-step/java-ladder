package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private final List<Point> points;

	public Line(Integer countOfPerson) {
		List<Point> points = new ArrayList<>();
		points.add(Point.createPoint(Math.random() > 0.5));
		for (int i = 1; i < countOfPerson - 1; i++) {
			pointsAdd(points, i);
		}
		this.points = points;
	}

	private static void pointsAdd(final List<Point> points, final int i) {
		if (points.get(i - 1).equals(Point.createPoint(true))) {
			points.add(Point.createPoint(false));
			return;
		}
		points.add(Point.createPoint(Math.random() > 0.5));
	}

	public static Line createLine(Integer countOfPerson) {
		return new Line(countOfPerson);
	}

	public int size() {
		return points.size();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Point point : points) {
			sb.append("|");
			appendPoint(point, sb);
		}
		sb.append("|");
		return sb.toString();
	}

	private static void appendPoint(final Point point, final StringBuilder sb) {
		if (point.equals(Point.createPoint(true))) {
			sb.append("-----");
			return;
		}
		sb.append("     ");
	}
}
