package study2.domain;

import java.util.Random;

public class RandomGenerator {
	
	static Random random = new Random();
	
	public static boolean randomGenratoring() {
		return random.nextBoolean();
	}
}
