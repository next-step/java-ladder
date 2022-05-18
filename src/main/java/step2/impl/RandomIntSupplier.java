package step2.impl;

import java.util.Random;
import java.util.function.IntSupplier;

public class RandomIntSupplier implements IntSupplier {

	private static final Random RANDOM = new Random();

	@Override
	public int getAsInt() {
		return RANDOM.nextInt(10);
	}
}
