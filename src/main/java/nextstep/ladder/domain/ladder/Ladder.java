package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import nextstep.ladder.domain.movestrategy.PointStrategy;

public class Ladder {

	private final List<Line> ladder = new ArrayList<>();
	private final PointStrategy pointStrategy;

	public Ladder(int length, int height, PointStrategy pointStrategy) {
		this.pointStrategy = pointStrategy;
		IntStream.range(0, height)
			.forEach(count -> ladder.add(new Line(length, pointStrategy)));
	}

	public List<Line> getLadder() {
		return this.ladder;
	}
}
