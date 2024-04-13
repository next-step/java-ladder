package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
	private final List<Line> lines;

	public Ladder(final int numberOfPeople, final Height height) {
		lines = Stream.generate(() -> new Line(new RandomGenerator(), numberOfPeople))
			.limit(height.getValue())
			.collect(Collectors.toList());
	}
	public List<Line> getLines() {
		return lines;
	}
}
