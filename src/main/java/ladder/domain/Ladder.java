package ladder.domain;

import ladder.domain.policy.PointConnectPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ladder {

	private static final int FIRST_LINE_INDEX = 0;

	private final List<Line> lines = new ArrayList<>();

	private Ladder(PointConnectPolicy policy, String[] names, int lineHeight) {
		makeLines(names, lineHeight);
		makeStep(policy);
	}

	private Ladder(List<Line> lines) {
		this.lines.addAll(lines);
	}

	public static Ladder of(PointConnectPolicy policy, String[] names, int lineHeight) {
		return new Ladder(policy, names, lineHeight);
	}

	public static Ladder of(List<Line> lines) {
		return new Ladder(lines);
	}

	private void makeLines(String[] names, int lineHeight) {
		for (String name : names) {
			lines.add(Line.of(name, lineHeight));
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

	@Override
	public String toString() {
		return String.format("%s\n%s", getPlayerNames(), drawLadder());
	}

	private StringBuilder getPlayerNames() {
		return alignPlayerNames(lines.stream()
				.map(Line::getPlayerName)
				.map(playerName -> playerName.orElseThrow(() ->
						new IllegalStateException("사다리 이름이 비어 있습니다")))
				.collect(Collectors.toList()));
	}

	private StringBuilder alignPlayerNames(List<String> names) {
		StringBuilder stringBuilder = new StringBuilder();
		for (String name : names) {
			stringBuilder.append(String.format("%6s", name));
		}
		return stringBuilder;
	}

	private StringBuilder drawLadder() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0, end = lines.get(0).getHeight(); i < end; i++) {
			stringBuilder.append("     ");
			stringBuilder.append(drawOneLine(lines, i));
			stringBuilder.append("\n");
		}
		return stringBuilder;
	}

	private StringBuilder drawOneLine(List<Line> lines, int index) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Line line : lines) {
			stringBuilder.append(line.toStringOfPoint(index));
		}
		return stringBuilder;
	}

}
