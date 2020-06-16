package study2.domain;

import java.util.Random;

public class RandomGenerator {

	Random random = new Random();
	private boolean randomValue;
		
	// Q 이렇게사용하는건 어떻게 생각하시나요?	
	public RandomGenerator() {
		this.randomValue = random.nextBoolean();
	}
	
	public boolean getRandom() {
		return randomValue;
	}
	
}
