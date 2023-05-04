package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

	private final List<Line> lines;

	public Ladder(int countOfPerson, int height) {
		if (countOfPerson < 1) {
			throw new IllegalArgumentException("참여할 사람의 수는 최소 1명 입니다.");
		}
		if (height < 1) {
			throw new IllegalArgumentException("사다리 높이는 최소 1 입니다.");
		}
		this.lines = new ArrayList<>();
		IntStream.range(0, height).forEach(i -> this.lines.add(new Line(countOfPerson)));
	}
}
