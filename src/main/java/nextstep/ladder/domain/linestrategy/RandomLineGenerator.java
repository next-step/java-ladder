package nextstep.ladder.domain.linestrategy;

import java.util.Random;

import nextstep.ladder.domain.ladder.Line;

public class RandomLineGenerator implements LineGenerator {

	private static final Random RANDOM = new Random();

	@Override
	public Boolean generatePoint(int index, Line line) {
		if (line.hasLine(index)) {
			return false;
		}
		return generateRandomBoolean();
	}

	private Boolean generateRandomBoolean() {
		return RANDOM.nextBoolean();
	}
}