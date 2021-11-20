package nextstep.ladder.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import nextstep.ladder.domain.Point;

public class RandomPointGenerator implements PointGenerator {
	private static final Random RANDOM = new Random();

	private static final int ONE = 1;
	private static final int ZERO = 0;

	@Override
	public List<Point> generate(int width, int height) {
		List<Point> points = new ArrayList<>();

		for (int i = ZERO; i < height; i++) {
			createHorizontalLine(points, width);
		}

		return points;
	}

	private void createHorizontalLine(List<Point> points, int width) {
		Point point = Point.createFirstOfLine(RANDOM.nextBoolean());
		points.add(point);

		for (int i = ONE; i < width - ONE; i++) {
			Point current = Point.create(point.hasRight(), calculateRight(point.hasRight()));
			points.add(current);
			point = current;
		}

		points.add(Point.createLastOfLine(point.hasRight()));
	}

	private boolean calculateRight(boolean beforeHasRight) {
		if (beforeHasRight) {
			return false;
		}
		return RANDOM.nextBoolean();
	}
}
