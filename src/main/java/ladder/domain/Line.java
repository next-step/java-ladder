package ladder.domain;

import java.util.Objects;

public class Line {

	private final Points points;

	public static Line of(Boolean... points) {
		return new Line(Points.of(points));
	}

	public Line(Points points) {
		this.points = points;
	}

	public int nextIndex(int index) {
		return this.points.nextIndex(index);
	}

	public Points getPoints() {
		return this.points;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Line line = (Line)o;
		return Objects.equals(points, line.points);
	}

	@Override
	public int hashCode() {
		return Objects.hash(points);
	}
}
