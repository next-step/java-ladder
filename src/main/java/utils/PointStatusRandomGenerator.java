package utils;

import java.util.Random;

public class PointStatusRandomGenerator {

	private Random random;

	public PointStatusRandomGenerator() {
		random = new Random();
	}

	public boolean randomStatus() {
		return random.nextBoolean();
	}
}
