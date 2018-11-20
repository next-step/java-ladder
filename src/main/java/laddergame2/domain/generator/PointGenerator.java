package laddergame2.domain.generator;

import java.util.ArrayList;
import java.util.List;
import laddergame2.domain.Point;

public class PointGenerator {

	private int playerCount;
	private PointGenerationStrategy pointGenerationStrategy;

	public PointGenerator(int playerCount, PointGenerationStrategy pointGenerationStrategy) {
		this.playerCount = playerCount;
		this.pointGenerationStrategy = pointGenerationStrategy;
	}

	public List<Point> generate() {
		List<Point> points = new ArrayList<>();
		initFirst(points);
		initBody(points);
		initLast(points);
		return points;
	}

	private void initFirst(List<Point> points) {
		Point first = Point.first(pointGenerationStrategy.generate());
		points.add(first);
	}

	private void initBody(List<Point> points) {
		for (int index = 1; index < playerCount - 1; index++) {
			Point before = points.get(index - 1);
			points.add(before.next(pointGenerationStrategy.generate()));
		}
	}

	private void initLast(List<Point> points) {
		Point before = points.get(points.size() - 1);
		points.add(before.last());
	}
}
