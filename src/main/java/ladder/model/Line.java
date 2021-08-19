package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {

	private final List<Point> points;

	public Line(List<Point> points) {
		this.points = Collections.unmodifiableList(points);
	}

	public static Line createLine(int playerCount) {
		List<Point> points = new ArrayList<>();
		points.add(new Point(false));
		initBody(playerCount, points);
		return new Line(points);
	}

	private static void initBody(int playerCount, List<Point> points) {
		IntStream.range(1, playerCount)
			.forEach(i -> points.add(new Point(LineSketch.drawLine(points.get(i - 1).isDirection()))));
	}

	public List<Point> getPoints() {
		return points;
	}

	public int move(int position) {
		boolean right = false;
		if (position < points.size() - 1) {
			right = points.get(position + 1).isDirection();
		}
		return points.get(position).movePosition(position, right);
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
