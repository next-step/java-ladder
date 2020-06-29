package nextstep.ladder.util.painter;

import java.util.Random;

import nextstep.ladder.domain.point.Point;

public class RandomPaintingStrategy implements PaintingStrategy {

	private final Random random = new Random();

	@Override
	public Point drawPoint() {
		return Point.ofPoint(random.nextBoolean());
	}
}
