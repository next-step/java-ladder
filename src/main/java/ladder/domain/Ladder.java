package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {

	private static final int FIRST_LINE_INDEX = 0;
	private static final int STEP_SIZE = 5;

	private final List<Line> lines = new ArrayList<>();

	private Ladder(PointConnectPolicy policy, int lineWidth, int lineHeight) {
		makeLines(lineWidth, lineHeight);
		makeStep(policy);
	}

	private Ladder(List<Line> lines) {
		this.lines.addAll(lines);
	}

	public static Ladder of(PointConnectPolicy policy, int lineWidth, int lineHeight) {
		return new Ladder(policy, lineWidth, lineHeight);
	}

	public static Ladder of(List<Line> lines) {
		return new Ladder(lines);
	}

	private void makeLines(int lineWidth, int lineHeight) {
		for (int i = 0; i < lineWidth; i++) {
			lines.add(Line.of(lineHeight));
		}
	}

	private void makeStep(PointConnectPolicy policy) {
		for (int i = FIRST_LINE_INDEX, end = getLastLineToDrawStepIndex(); i < end; i++) {
			getLine(i).makeStepWithAdjacentLine(getNextLine(i), policy);
		}
	}

	private int getLastLineToDrawStepIndex() {
		return lines.size() - 2;
	}

	private Line getLine(int index) {
		return lines.get(index);
	}

	private Line getNextLine(int index) {
		return getLine(index + 1);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Ladder ladder = (Ladder) o;
		return Objects.equals(lines, ladder.lines);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lines);
	}

}
