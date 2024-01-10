package ladder.domain;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.Stream;

import ladder.util.PointGenerator;

public class Lines {
	private final List<Line> line;

	public Lines(List<Line> list) {
		this.line = list;
	}

	public static Lines of(People people, Height heightCount, PointGenerator pointGenerator) {
		return Stream
			.generate(() -> Line.of(people, pointGenerator))
			.limit(heightCount.find())
			.collect(collectingAndThen(toList(), Lines::new));
	}

	public List<Line> line() {
		return line;
	}
}
