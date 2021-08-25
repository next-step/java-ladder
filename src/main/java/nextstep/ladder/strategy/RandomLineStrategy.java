package nextstep.ladder.strategy;

import nextstep.ladder.model.Line;

public class RandomLineStrategy implements LineStrategy {

	private static final int SPACE_OPERATION_VALUE = 1;

	@Override
	public Line genereateLine(int count) {
		Line line = new Line();

		for (int i = 0; i < count - SPACE_OPERATION_VALUE; i++) {
			line.addRandomLadderStatus();
		}

		return line;
	}
}
