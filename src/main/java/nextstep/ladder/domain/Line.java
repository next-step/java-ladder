package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import nextstep.ladder.generator.RandomGenerator;
import nextstep.ladder.util.CollectionUtils;

public class Line {
	private static final String EMPTY_MESSAGE = "Point 리스트가 비어있습니다.";

	private final List<Point> points;

	private Line(List<Point> points) {
		validateSize(points);
		this.points = points;
	}

	private void validateSize(List<Point> points) {
		if (CollectionUtils.isEmpty(points)) {
			throw new IllegalArgumentException(EMPTY_MESSAGE);
		}
	}

	public static Line create(List<Point> points) {
		return new Line(points);
	}

	public static Line create(RandomGenerator generator, int width) {
		List<Point> points = new ArrayList<>();
		Point point = Point.createFirstOfLine(generator.generate());
		points.add(point);

		for (int i = 1; i < width - 1; i++) {
			Point current = Point.create(point.isDirectionRight(), calculateRight(generator, point.isDirectionRight()));
			points.add(current);
			point = current;
		}

		points.add(Point.createLastOfLine(point.isDirectionRight()));
		return create(points);
	}

	private static boolean calculateRight(RandomGenerator generator, boolean isPrevPointHasRightLine) {
		if (isPrevPointHasRightLine) {
			return false;
		}
		return generator.generate();
	}

	public int move(int position) {
		Point point = points.get(position);
		return point.move(position);
	}

	public List<Point> getPoints() {
		return Collections.unmodifiableList(points);
	}

	public int size() {
		return points.size();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Line line = (Line)obj;

		return Objects.equals(points, line.points);
	}

	@Override
	public int hashCode() {
		return Objects.hash(points);
	}

	@Override
	public String toString() {
		return "Line{" +
			"points=" + points +
			'}';
	}
}
