package nextstep.ladder.domain.linestrategy;

import java.util.List;

import nextstep.ladder.domain.ladder.Line;

public class ManualLineGenerator implements LineGenerator {

	private List<Boolean> points;

	public ManualLineGenerator(List<Boolean> points) {
		this.points = points;
	}

	@Override
	public Boolean generatePoint(int index, Line line) {
		return points.get(index);
	}
}
