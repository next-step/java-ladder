package ladder.domain;

import java.util.List;

public class Line {
	List<Boolean> points;

	public Line(int countOfPerson) {
		this(new RandomLineStrategy(), countOfPerson);
	}

	public Line(LineStrategy lineStrategy, int countOfPerson) {
		this.points = lineStrategy.points(countOfPerson);
	}

	public List<Boolean> getLine() {
		return points;
	}
}
