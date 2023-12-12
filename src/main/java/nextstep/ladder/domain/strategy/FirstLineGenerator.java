package nextstep.ladder.domain.strategy;

import java.util.ArrayList;
import java.util.List;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Point;

public class FirstLineGenerator implements LineGenerator {
	private final int height;

	public FirstLineGenerator(Height height) {
		this.height = height.height();
	}

	@Override
	public List<Point> generate() {
		List<Point> points = new ArrayList<>();
		for (int i = 0; i < height; i++) {
			points.add(Point.random());
		}
		return points;
	}
}
