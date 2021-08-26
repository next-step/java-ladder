package nextstep.step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {

	private final List<Point> points;

	public Line(List<Point> points) {
		this.points = new ArrayList<>(points);
	}

	public int move(int startPosition) {
		return points.get(startPosition).move();
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
