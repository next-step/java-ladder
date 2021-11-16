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
		Point prev = Point.createHasNotLine();
		List<Point> points = new ArrayList<>();

		for (int i = ZERO; i < width * height; i++) {
			Point target = createPoint(i, width);
			Point current = target.calculatePrev(prev);
			points.add(current);
			prev = current;
		}
		return points;
	}

	private Point createPoint(int idx, int width) {
		if (isLastIndexOfLine(idx, width)) {
			return Point.createHasNotLine();
		}
		return Point.create(RANDOM.nextBoolean());
	}

	private boolean isLastIndexOfLine(int idx, int width) {
		return (idx + ONE) % width == ZERO;
	}
}
