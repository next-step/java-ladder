package study2.domain;

public class Point {
	private boolean point;

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
