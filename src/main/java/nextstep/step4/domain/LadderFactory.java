package nextstep.step4.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFactory {

	private static final int INITIAL_INDEX = 0;

	private LadderFactory() {
	}

	public static Ladder from(Players players, int height) {
		List<Line> lines = IntStream.range(INITIAL_INDEX, height)
			.mapToObj(index -> LineFactory.from(players))
			.collect(Collectors.toList());
		return new Ladder(players.size(), lines);
	}

}
