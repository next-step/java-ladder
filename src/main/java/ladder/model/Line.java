package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import ladder.service.LadderMove;

public class Line {

	private final List<Boolean> points;

	public Line(List<Boolean> points) {
		this.points = Collections.unmodifiableList(points);
	}

	public List<Boolean> getPoints() {
		return points;
	}

	public int move(int position) {
		return LadderMove.move(position, points);
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
