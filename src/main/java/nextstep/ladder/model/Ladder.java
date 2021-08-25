package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;

import nextstep.ladder.strategy.LineStrategy;

public class Ladder {

	private final List<Line> lines;

	private Ladder(List<Line> lines) {
		this.lines = lines;
	}

	public static Ladder of(LineStrategy lineStrategy, int lineCount, int participantsCount) {
		List<Line> lines = new ArrayList<>(lineCount);

		for (int i = 0; i < lineCount; i++) {
			lines.add(lineStrategy.genereateLine(participantsCount));
		}

		return new Ladder(lines);
	}

	public Line getLine(int index) {
		return lines.get(index);
	}

	public int size() {
		return lines.size();
	}
}
