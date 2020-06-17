package nextstep.ladder.painter;

import java.util.Random;

import nextstep.ladder.point.Point;

public class RandomPaintingStrategyImpl implements PaintingStrategy {

	private final Random random = new Random();

	@Override
	public Point drawPoint() {
		return Point.ofPoint(random.nextBoolean());
	}
}
