package ladder.domain;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.Stream;

import ladder.util.PointGenerator;

public final class Lines {
	private final List<Line> line;

	public Lines(final List<Line> list) {
		this.line = list;
	}

	public static Lines of(final People people, final Height heightCount, final PointGenerator pointGenerator) {
		return Stream
			.generate(() -> Line.of(people, pointGenerator))
			.limit(heightCount.find())
			.collect(collectingAndThen(toList(), Lines::new));
	}

	public List<Line> line() {
		return line;
	}
}
