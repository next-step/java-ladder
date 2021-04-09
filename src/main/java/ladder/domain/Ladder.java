package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
	private static final int LADDER_MIN_SIZE = 3;
	private static final String LADDER_MIN_SIZE_ERROR_MSG = "사다리 높이는 최소 3이상이어야 합니다";

	private final List<Line> ladder;

	public Ladder(int countOfPerson, int ladderSize) {
		this(IntStream.range(0, ladderSize).mapToObj((n) -> new Line(countOfPerson)).collect(Collectors.toList()));
	}

	public Ladder(List<Line> lines) {
		validateLadderSize(lines.size());
		this.ladder = lines;
	}

	private void validateLadderSize(int ladderSize) {
		if (ladderSize < LADDER_MIN_SIZE) {
			throw new IllegalArgumentException(LADDER_MIN_SIZE_ERROR_MSG);
		}
	}

	public List<Line> getLadder() {
		return ladder;
	}

	public int moveLine(int startPosition) {
		int currentPosition = startPosition;
		for (int line = 0; line < ladder.size(); line++) {
			currentPosition += this.ladder.get(line).movePoint(currentPosition);
		}
		return currentPosition;
	}
}
