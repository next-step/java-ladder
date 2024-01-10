package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import ladder.util.PointGenerator;

public class Line {
	private final List<Direction> line;

	public Line(List<Direction> line) {
		this.line = line;
	}

	public static Line of(People people, PointGenerator pointGenerator) {
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
