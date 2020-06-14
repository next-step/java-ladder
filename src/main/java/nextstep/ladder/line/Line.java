package nextstep.ladder.line;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private List<Boolean> points = new ArrayList<>();

	public Line(int playerCount) {
		// this.points = new LineGenerator().create();
	}

	public List<Boolean> getPoints() {
		return points;
	}
}
