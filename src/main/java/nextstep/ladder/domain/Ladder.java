package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
	public static final int MINIMUM_COUNT = 1;
	public static final String LADDER_HEIGHT_NOT_VALID = "사다리 높이가 1보다 작습니다.";
	private final List<Line> lines;

	public Ladder(int countOfPerson, int height) {
		validate(height);
		this.lines = IntStream
			.range(0, height)
			.mapToObj(n -> new Line(countOfPerson))
			.collect(Collectors.toList());
	}

	public void play(Participant participant) {
		this.lines.stream().forEachOrdered(line -> line.play(participant));
	}

	private void validate(int height) {
		if (height < MINIMUM_COUNT) {
			throw new IllegalArgumentException(LADDER_HEIGHT_NOT_VALID);
		}
	}

	public List<Line> list() {
		return this.lines;
	}
}
