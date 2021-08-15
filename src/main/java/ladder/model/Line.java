package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import ladder.dto.LineDto;

public class Line {

	private final List<Boolean> points;

	public Line(List<Boolean> points) {
		this.points = Collections.unmodifiableList(points);
	}

	public List<Boolean> getPoints() {
		return LineDto.of(points).values();
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
