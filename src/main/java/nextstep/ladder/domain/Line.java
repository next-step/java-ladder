package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Line {
	private final List<Boolean> points = new ArrayList<>();

	public Line(final int numberOfPeople) {
		final Random random = new Random();
		while (points.size() < numberOfPeople - 1){
			final boolean now = random.nextBoolean();
			if (isDifferentFromPrevious(now)) {
				points.add(now);
			}
		}
	}

	private boolean isDifferentFromPrevious(final boolean now) {
		return points.isEmpty() || points.get(points.size() - 1) != now;
	}

	public List<Boolean> getPoints() {
		return points;
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
