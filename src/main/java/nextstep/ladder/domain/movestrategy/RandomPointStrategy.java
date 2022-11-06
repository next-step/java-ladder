package nextstep.ladder.domain.movestrategy;

import java.util.Random;

import nextstep.ladder.domain.ladder.Line;

public class RandomPointStrategy implements PointStrategy {
	private static final Random RANDOM = new Random();

	@Override
	public boolean isAddible(int index, Line line) {
		if (line.hasEitherLine(index)) {
			return false;
		}
		return generateRandomBooolean();
	}

	private Boolean generateRandomBooolean() {
		return RANDOM.nextBoolean();
	}
}