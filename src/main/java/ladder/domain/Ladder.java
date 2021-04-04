package ladder.domain;

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
		validateLadderSize(args.length);
		this.ladder = Arrays.stream(args).collect(Collectors.toList());
	}

	public List<Line> getLadder() {
		return ladder;
	}

	private void validateLadderSize(int ladderSize) {
		if (ladderSize < 3) {
			throw new IllegalArgumentException("사다리 높이는 최소 3이상이어야 합니다");
		}
	}
}
