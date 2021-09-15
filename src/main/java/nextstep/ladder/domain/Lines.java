package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
	public static final int MINIMUM_COUNT = 1;
	private final List<Line> lines;

	public Lines(int countOfPerson, int height) {
		validate(height);
		this.lines = IntStream
			.range(0, height)
			.mapToObj(n -> new Line(countOfPerson))
			.collect(Collectors.toList());
	}

	private void validate(int height) {
		if (height < MINIMUM_COUNT) {
			throw new IllegalArgumentException("사다리 높이가 1보다 작습니다.");
		}
	}

	public List<Line> list() {
		return this.lines;
	}
}
