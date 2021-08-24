package nextstep.ladder.strategy;

import nextstep.ladder.model.Line;

public class RandomLineStrategy implements LineStrategy {

	@Override
	public Line genereateLine(int count) {
		Line line = new Line();

		for (int i = 0; i < count; i++) {
			line.addRandomLadderStatus();
		}

		return line;
	}
}
