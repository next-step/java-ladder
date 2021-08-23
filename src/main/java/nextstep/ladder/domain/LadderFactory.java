package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFactory {

	private static final int INITIAL_INDEX = 0;

	private LadderFactory() {
	}

	public static Ladder from(Players players, Height height) {
		List<Line> lines = IntStream.range(INITIAL_INDEX, height.value())
			.mapToObj(index -> LineFactory.from(players))
			.collect(Collectors.toList());
		return new Ladder(players, lines);
	}

}
