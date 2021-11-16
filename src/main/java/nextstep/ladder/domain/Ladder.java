package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import nextstep.ladder.generator.PointGenerator;
import nextstep.ladder.util.CollectionUtils;

public class Ladder {
	private static final String EMPTY_MESSAGE = "Point 리스트가 비어있습니다.";
	private static final String OVERLAP_MESSAGE = "사다리 라인이 겹쳐지면 안됩니다.";

	private final List<Point> points;

	private Ladder(List<Point> points) {
		validate(points);
		this.points = new ArrayList<>(points);
	}

	private void validate(List<Point> points) {
		validateSize(points);
		validateOverlap(points);
	}

	private void validateSize(List<Point> points) {
		if (CollectionUtils.isEmpty(points)) {
			throw new IllegalArgumentException(EMPTY_MESSAGE);
		}
	}

	private void validateOverlap(List<Point> points) {
		for (int i = 0; i < points.size() - 1; i++) {
			comparePoint(points, i);
		}
	}

	private void comparePoint(List<Point> points, int idx) {
		Point current = points.get(idx);
		Point next = points.get(idx + 1);
		if (current.hasLine() && next.hasLine()) {
			throw new IllegalArgumentException(OVERLAP_MESSAGE);
		}
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
