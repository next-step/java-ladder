package ladder.domain;

import java.util.List;

public class Line {
	private final List<Cross> crosses;

	public Line(int countOfPerson) {
		this(new RandomLineStrategy(), countOfPerson);
	}

	public Line(LineStrategy lineStrategy, int countOfPerson) {
		this.crosses = lineStrategy.crosses(countOfPerson);
	}

	public List<Cross> getCrosses() {
		return crosses;
	}

	public int movePoint(int startPosition) {
		return crosses.get(startPosition).move();
	}

}
