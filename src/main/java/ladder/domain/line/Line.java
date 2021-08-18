package ladder.domain.line;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {

	private final List<Boolean> points;

	private Line(List<Boolean> points) {
		validateConsecutiveLine(points);
		this.points = points;
	}

	public static Line of(int playersCount) {
		return new Line(LineGenerator.generate(playersCount - 1));
	}

	public static Line of(List<Boolean> points) {
		return new Line(points);
	}

	private void validateConsecutiveLine(List<Boolean> points) {
		if (hasConsecutiveLine(points)) {
			throw new LineContinuousException();
		}
	}

	private boolean hasConsecutiveLine(List<Boolean> points) {
		return IntStream.range(0, points.size() - 1)
		                .anyMatch(i -> points.get(i) && points.get(i + 1));
	}

	public List<Boolean> getPoints() {
		return Collections.unmodifiableList(points);
	}

	public int size() {
		return points.size();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Line line = (Line) o;
		return Objects.equals(points, line.points);
	}

	@Override
	public int hashCode() {
		return Objects.hash(points);
	}

}
