package nextstep.ladder.domain.strategy;

import java.util.Random;

import nextstep.ladder.domain.Point;
import nextstep.ladder.engine.strategy.PointGenerateStrategy;

public class RandomPointGenerateStrategy implements PointGenerateStrategy {
	private static final Random random = new Random();

	@Override
	public Point generate() {
		Point[] points = {Point.RIGHT, Point.HOLD};
		return points[random.nextInt(points.length)];
	}
}
