package utils;

import domain.Point;

import java.util.Random;

public class PointStatusRandomGenerator {

	private Random random;

	public PointStatusRandomGenerator() {
		random = new Random();
	}

	public boolean randomStatus() {
		return random.nextBoolean();
	}

	public boolean randomStatus(Point point) {
		if (point.status()) {
			return false;
		}
		return random.nextBoolean();
	}
}
