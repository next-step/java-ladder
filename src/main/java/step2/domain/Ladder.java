package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
	private final List<Line> lines;

	public Ladder(List<Line> lines) {
		this.lines = lines;
	}

	public static Ladder makeLadder(int countOfPerson, int height) {
		List<Line> lines = new ArrayList<>();
		for (int i = 0; i < height; i++) {
			lines.add(new Line(countOfPerson));
		}
		return new Ladder(lines);
	}
}
