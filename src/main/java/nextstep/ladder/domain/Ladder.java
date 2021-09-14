package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import nextstep.ladder.domain.strategy.LineRandomStrategy;
import nextstep.ladder.domain.strategy.LineStrategy;
import nextstep.ladder.exception.MinimumLadderHeightException;

public class Ladder {
	private static final int MIN_LADDER_HEIGHT = 1;
	private static final String MIN_LADDER_HEIGHT_EXCEPTION_MESSAGE = "사다리의 최소 높이는 %d 입니다.";

	private final List<Line> lines;

	public Ladder(int players, int height) {
		checkLadderHeight(height);
		LineStrategy lineStrategy = new LineRandomStrategy();
		lines = Stream.generate(() -> new Line(players, lineStrategy))
			.limit(height)
			.collect(Collectors.toList());
	}

	private void checkLadderHeight(int height) {
		if (height < MIN_LADDER_HEIGHT) {
			throw new MinimumLadderHeightException(
				String.format(MIN_LADDER_HEIGHT_EXCEPTION_MESSAGE, MIN_LADDER_HEIGHT));
		}
	}
}