package study2.domain;

public class Point {
	private boolean point;

	// Question
	// Point 객체가  
	// boolean point도 받을 수 있고
	// 랜덤값도 받을 수있는 객체이다. 
	// 이런거는 어떻게 생각하시나요?
	
	public Point(boolean point) {
		this.point = point;
	}

	public Point(RandomGenerator randomGenerator) {
		this.point = randomGenerator.getRandom();
	}

	public boolean getPoint() {
		return point;
	}
}
