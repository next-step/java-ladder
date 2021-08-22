package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {

	private final List<Point> points;

	public Line(List<Point> points) {
		this.points = Collections.unmodifiableList(points);
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
