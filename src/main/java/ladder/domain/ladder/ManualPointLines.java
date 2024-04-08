package ladder.domain.ladder;

import java.util.List;

public class ManualPointLines implements LinesStrategy {
	private final List<List<PointEnum>> points;

	public ManualPointLines(List<List<PointEnum>> points) {
		this.points = points;
	}

	@Override
	public Lines makeLines(int height ,int countOfPerson) {
		return Lines.createManualLines(height, countOfPerson, points);
	}
}
