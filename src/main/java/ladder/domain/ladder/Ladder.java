package ladder.domain.ladder;

import java.util.List;

public class Ladder {
	private final int height;
	private final List<Line> lines;

	public Ladder(int height, List<Line> lines) {
		this.height = height;
		this.lines = lines;
	}
}
