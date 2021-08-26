package nextstep.step4.domain;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LadderFactory {

	private static final int INITIAL_INDEX = 0;

	private LadderFactory() {
	}

	public static Ladder from(Players players, Height height, Prizes prizes) {
		List<Line> lines = IntStream.range(INITIAL_INDEX, height.value())
							.mapToObj(index -> LineFactory.from(players))
							.collect(collectingAndThen(toList(), Collections::unmodifiableList));
		return new Ladder(players, prizes, lines);
	}

}
