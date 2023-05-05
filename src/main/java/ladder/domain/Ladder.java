package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

	private static final int COUNT_OF_PERSON_MINIMUM = 1;

	private final Lines lines;
	private final Height height;

	public Ladder(int countOfPerson, int height) {
		if (countOfPerson < Ladder.COUNT_OF_PERSON_MINIMUM) {
			throw new IllegalArgumentException(String.format("참여할 사람의 수는 최소 %d명 입니다. 입력값: %d", Ladder.COUNT_OF_PERSON_MINIMUM, countOfPerson));
		}
		this.lines = new Lines(new ArrayList<>());
		this.height = new Height(height);
		IntStream.range(0, height).forEach(i -> this.lines.add(new Line(countOfPerson)));
	}

	public List<Line> getLines() {
		return this.lines.getLines();
	}
}
