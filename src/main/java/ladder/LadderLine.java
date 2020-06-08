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
				.mapToObj(i -> new LadderLinePoint())
				.collect(collectingAndThen(toList(), LadderLinePoints::new));
	}

	public LadderLinePoints getLadderLinePoints() {
		return ladderLinePoints;
	}
}
