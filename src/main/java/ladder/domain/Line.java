package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

	private static final Random random = new Random();

	private final List<Boolean> points;
	private boolean beforePoint;

	public Line(int countOfPerson) {
		this.points = new ArrayList<>();
		this.beforePoint = false;
		for (int i = 0; i < countOfPerson - 1; i++) {
			this.addPoint();
		}
	}

	private void addPoint() {
		if (this.beforePoint) {
			this.addFalse();
			return;
		}
		this.addRandomBoolean();
	}

	private void addFalse() {
		this.beforePoint = false;
		this.points.add(false);
	}

	private void addRandomBoolean() {
		this.beforePoint = Line.random.nextBoolean();
		this.points.add(beforePoint);
	}

	public List<Boolean> getPoints() {
		return this.points;
	}
}
