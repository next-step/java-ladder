package nextstep.ladder.domain.linestrategy;

import java.util.List;

public class ManualLineGenerator implements LineGenerator {

	private int index = 0;
	private List<Boolean> points;

	public ManualLineGenerator(List<Boolean> points) {
		this.points = points;
	}

	@Override
	public Boolean generatePoint() {
		return this.points.get(index++);
	}
}
