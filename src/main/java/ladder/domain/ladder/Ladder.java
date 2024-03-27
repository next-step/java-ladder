package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
	private final int height;
	private final List<Line> lines;

	public Ladder(int height, List<Line> lines) {
		this.height = height;
		this.lines = lines;
	}

	public static Ladder createLadder(int height, int countOfPerson) {
		List<Line> lines = new ArrayList<>();
		for (int i = 0; i < height; i++) {
			lines.add(Line.createLine(countOfPerson));
		}
		return new Ladder(height, lines);
	}

	public void printLadder() {
		for (Line line : lines) {
			System.out.println(line.toString());
		}
	}

	public int getHeight() {
		return height;
	}
}
