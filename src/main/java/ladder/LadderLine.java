package ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {

	private final List<Point> points = new ArrayList<>();

	public LadderLine(int playersCount) {
		for (int i = 0; i < playersCount; i++) {
			points.add(new Point());
		}
	}

	public List<Point> getPoints() {
		return points;
	}
}
