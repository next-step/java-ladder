package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

	private static final int SPACE_OPERATION_VALUE = 1;

	private final List<Line> lines;

	private Ladder(List<Line> lines) {
		this.lines = lines;
	}

	public static Ladder of(int lineCount, int participantsCount) {
		List<Line> lines = new ArrayList<>(lineCount);

		for (int i = 0; i < lineCount; i++) {
			lines.add(generateLine(participantsCount));
		}

		return new Ladder(lines);
	}

	public Line getLine(int index) {
		return lines.get(index);
	}

	public int size() {
		return lines.size();
	}

	private static Line generateLine(int participantsCount) {
		Line line = new Line();

		for (int i = 0; i < participantsCount - SPACE_OPERATION_VALUE; i++) {
			line.addRandomLadderStatus();
		}

		return line;
	}
}
