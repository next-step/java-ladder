package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import nextstep.ladder.domain.strategy.LineStrategy;

public class Line {
	private static final int START_INDEX = 1;
	private static final int MIN_INDEX = 0;
	private static final int PRE_INDEX = 1;
	private static final String START_LINE = "      |";
	private static final String EXIST_LINE = "-----|";
	private static final String EMPTY_LINE = "     |";

	private final List<Boolean> points = new ArrayList<>();

	public Line(int players, LineStrategy lineStrategy) {
		IntStream.range(START_INDEX, players)
			.forEach(index -> createPoints(lineStrategy));
	}

	private void createPoints(LineStrategy lineStrategy) {
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

	@Override
	public String toString() {
		StringBuilder view = new StringBuilder();
		view.append(START_LINE);
		points.forEach(point -> {
			if (point) {
				view.append(EXIST_LINE);
				return;
			}
			view.append(EMPTY_LINE);

		});

		return view.toString();
	}
}