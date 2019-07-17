package ladder;

import ladder.domain.StepProvider;

import java.util.Random;

public class RandomStepProvider implements StepProvider {

	Random random;

	public RandomStepProvider() {
		this.random = new Random();
	}

	@Override
	public boolean generate() {
		return random.nextBoolean();
	}
}
