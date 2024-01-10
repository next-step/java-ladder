package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import ladder.util.PointGenerator;

public final class Line {
	private final List<Direction> line;

	public Line(final List<Direction> line) {
		this.line = line;
	}

	public static Line of(final People people, final PointGenerator pointGenerator) {
		Direction direction = Direction.first(pointGenerator.generate());
		List<Direction> list = new ArrayList<>();
		list.add(direction);

		for (int i = 1; i < people.count() - 1; i++) {
			direction = direction.next(pointGenerator.generate());
			list.add(direction);
		}

		list.add(direction.end());

		return new Line(list);
	}

	public List<Direction> draw() {
		return Collections.unmodifiableList(line);
	}
}
