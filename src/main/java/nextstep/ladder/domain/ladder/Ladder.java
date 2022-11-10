package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import nextstep.ladder.domain.linestrategy.LineGenerator;

public class Ladder {

	private final List<Line> ladder = new ArrayList<>();

	public Ladder(int length, int height, LineGenerator lineGenerator) {
		IntStream.range(0, height)
			.forEach(count -> ladder.add(new Line(length, lineGenerator)));
	}

	public List<Line> getLadder() {
		return this.ladder;
	}
}
