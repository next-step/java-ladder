package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
	private static final Random random = new Random();
	private final List<Boolean> points = new ArrayList<>();

	public Line(int countOfPerson) {
		for (int i = 0; i < countOfPerson; i++) {
			points.add(createPoint());
		}
	}

	private boolean createPoint() {
		if (points.lastIndexOf(true) == points.size() - 1) {
			return false;
		}
		return random.nextBoolean();
	}
}
