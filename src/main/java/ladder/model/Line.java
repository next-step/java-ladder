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

	public static Line createLine(int playerCount, LineSketch lineSketch) {
		List<Point> points = new ArrayList<>();
		points.add(new Point(false, checkPrevDirection(false, lineSketch)));
		initBody(playerCount, points, lineSketch);
		points.add(new Point(points.get(points.size() - 1).isRight(), false));
		return new Line(points);
	}

	private static void initBody(int playerCount, List<Point> points, LineSketch lineSketch) {
		IntStream.range(1, playerCount - 1).forEach(i -> {
			boolean right = points.get(i - 1).isRight();
			points.add(new Point(right, checkPrevDirection(right, lineSketch)));
		});
	}

	private static boolean checkPrevDirection(boolean right, LineSketch lineSketch) {
		if (right) {
			return false;
		}
		return lineSketch.drawLine();
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
