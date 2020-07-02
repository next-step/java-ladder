package nextstep.ladder.util.painter;

import java.util.Random;

public class RandomPaintingStrategy implements PaintingStrategy {

	private final Random random = new Random();

	@Override
	public boolean isRight() {
		return random.nextBoolean();
	}
}
