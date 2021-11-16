package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import nextstep.ladder.generator.PointGenerator;

public class Ladder {
	private final List<Point> points;

	private Ladder(List<Point> points) {
		this.points = new ArrayList<>(points);
	}

	public static Ladder create(List<Point> points) {
		return new Ladder(points);
	}

	public static Ladder create(PointGenerator generator, int width, int height) {
		return create(generator.generate(width, height));
	}

	public List<Point> values() {
		return Collections.unmodifiableList(points);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Ladder ladder = (Ladder)obj;

		return Objects.equals(points, ladder.points);
	}

	@Override
	public int hashCode() {
		return Objects.hash(points);
	}

	@Override
	public String toString() {
		return "Ladder{" +
			"points=" + points +
			'}';
	}
}
