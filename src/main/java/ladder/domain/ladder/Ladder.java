package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
	private final Height height;
	private final List<Line> lines;

	public Ladder(Height height, List<Line> lines) {
		this.height = height;
		this.lines = lines;
	}

	public static Ladder createLadder(Height height, int countOfPerson) {
		List<Line> lines = new ArrayList<>();
		for (int i = 0; i < height.getHeight(); i++) {
			lines.add(Line.createLine(countOfPerson));
		}
		return new Ladder(height, lines);
	}

	public int getHeight() {
		return height.getHeight();
	}

	public List<Line> getLines() {
		return lines;
	}
}
