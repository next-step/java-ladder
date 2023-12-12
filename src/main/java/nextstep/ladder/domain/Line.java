package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

import nextstep.ladder.domain.strategy.LineGenerator;

public class Line {
	private final List<Point> points;

	public Line(List<Point> points) {
		this.points = points;
	}

	public Line(LineGenerator generator) {
		this.points = generator.generate();
	}

	public List<Point> points() {
		return Collections.unmodifiableList(points);
	}
}
