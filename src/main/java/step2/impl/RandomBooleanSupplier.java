package step2.impl;

import java.util.Random;
import java.util.function.BooleanSupplier;

public class RandomBooleanSupplier implements BooleanSupplier {

	private static final Random RANDOM = new Random();

	@Override
	public boolean getAsBoolean() {
		return RANDOM.nextBoolean();
	}
}
