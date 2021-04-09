package ladder.domain;

import java.util.List;

public class Line {
	private final List<Boolean> points;

	public Line(int countOfPerson) {
		this(new RandomLineStrategy(), countOfPerson);
	}

	public Line(LineStrategy lineStrategy, int countOfPerson) {
		this.points = lineStrategy.points(countOfPerson);
	}

	public List<Boolean> getPoints() {
		return points;
	}

	public int movePoint(int startPoint) {
		if (isMove(startPoint)) {
			return 1;
		}
		if (isMove(startPoint - 1)) {
			return -1;
		}
		return 0;
	}

	private boolean isMove(int currentPosition) {
		if (currentPosition < 0) {
			return false;
		}
		return this.points.get(currentPosition);
	}
}
