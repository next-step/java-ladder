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
		points.add(new Point(false, new LineSketch().drawLine()));
		initBody(playerCount, points);
		points.add(new Point(points.get(points.size() - 1).isRight(), false));
		return new Line(points);
	}

	private static void initBody(int playerCount, List<Point> points) {
		IntStream.range(1, playerCount - 1).forEach(i -> {
			boolean right = points.get(i - 1).isRight();
			points.add(new Point(right, checkPrevDirection(right)));
		});
	}

	private static boolean checkPrevDirection(boolean right) {
		if (right) {
			return false;
		}
		return new LineSketch().drawLine();
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
