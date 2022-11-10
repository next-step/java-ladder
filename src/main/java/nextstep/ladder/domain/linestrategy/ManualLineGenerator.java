package nextstep.ladder.domain.linestrategy;

import nextstep.ladder.domain.ladder.Line;

public class ManualLineGenerator implements LineGenerator {

	@Override
	public Boolean generatePoint(int index, Line line) {
		return line.getPoints().get(index);
	}
}
