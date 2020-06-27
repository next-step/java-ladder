package study3.domain;

import java.util.Random;

public class RandomGenerator {

	private static boolean randomValue;
		
	public RandomGenerator() {
		this.randomValue = new Random().nextBoolean();
	}
	
	public static boolean getRandom() {
		return randomValue;
	}
	
}
