package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
	List<Line> ladder;

	public Ladder(int countOfPerson, int ladderSize) {
		this(IntStream.range(0, ladderSize).mapToObj((n) -> new Line(countOfPerson)).toArray(Line[]::new));
	}

	public Ladder(Line... args) {
		this.ladder = Arrays.stream(args).collect(Collectors.toList());
	}

	public List<Line> getLadder() {
		return ladder;
	}
}
