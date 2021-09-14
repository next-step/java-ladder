package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import nextstep.ladder.domain.strategy.LineStrategy;

public class Line {
	private static final int START_INDEX = 1;
	private static final int MIN_INDEX = 0;
	private static final int PRE_INDEX = 1;

	private final List<Boolean> points = new ArrayList<>();
	private final LineStrategy lineStrategy;

	public Line(int players, LineStrategy lineStrategy) {
		this.lineStrategy = lineStrategy;
		IntStream.range(START_INDEX, players)
			.forEach(index -> createPoints());
	}

	private void createPoints() {
		int preIndex = points.size() - PRE_INDEX;
		boolean strategy = lineStrategy.createPoint();

		if (preIndex < MIN_INDEX) {
			points.add(strategy);
			return;
		}

		if (points.get(preIndex)) {
			points.add(false);
			return;
		}

		points.add(strategy);
	}
}