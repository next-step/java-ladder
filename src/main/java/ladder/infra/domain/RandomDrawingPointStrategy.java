package ladder.infra.domain;

import ladder.domain.point.DrawingPointStrategy;
import ladder.domain.point.Point;

import java.util.Random;

public class RandomDrawingPointStrategy implements DrawingPointStrategy {

	private final Random random = new Random();

	@Override
	public Point drawPoint() {
		return Point.of(random.nextBoolean());
	}
}
