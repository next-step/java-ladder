package ladder;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderLine {

	private final LadderLinePoints ladderLinePoints;

	public LadderLine(int playersCount) {
		this.ladderLinePoints = drawPoints(playersCount);
	}

	private LadderLinePoints drawPoints(int playersCount) {
		return IntStream.range(0, playersCount)
				.mapToObj(i -> LadderLinePoint.of(false))
				.collect(collectingAndThen(toList(), LadderLinePoints::of));
	}

	public LadderLinePoints getLadderLinePoints() {
		return ladderLinePoints;
	}
}
