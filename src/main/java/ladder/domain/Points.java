package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Points {

	private final List<Boolean> points;

	public Points(List<Boolean> points) {
		this.points = points;
	}

	public void add(boolean point) {
		this.points.add(point);
	}

	public String createLineText() {
		return this.points.stream()
			.map(point -> point ? Line.TRUE_TEXT : Line.FALSE_TEXT)
			.collect(Collectors.joining(Height.HEIGHT_TEXT, Height.HEIGHT_TEXT, Height.HEIGHT_TEXT));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Points points1 = (Points)o;
		return Objects.equals(points, points1.points);
	}

	@Override
	public int hashCode() {
		return Objects.hash(points);
	}
}
