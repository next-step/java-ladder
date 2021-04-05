package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
	private final List<Line> ladder;
	private static final int LADDER_MIN_SIZE = 3;
	private static final String LADDER_MIN_SIZE_ERROR_MSG = "사다리 높이는 최소 3이상이어야 합니다";

	public Ladder(int countOfPerson, int ladderSize) {
		this(IntStream.range(0, ladderSize).mapToObj((n) -> new Line(countOfPerson)).collect(Collectors.toList()));
	}

	public Ladder(List<Line> lines) {
		validateLadderSize(lines.size());
		this.ladder = lines;
	}

	public List<Line> getLadder() {
		return ladder;
	}

	private void validateLadderSize(int ladderSize) {
		if (ladderSize < LADDER_MIN_SIZE) {
			throw new IllegalArgumentException(LADDER_MIN_SIZE_ERROR_MSG);
		}
	}
}
