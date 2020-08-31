package laddergame.domain.ladder;

import laddergame.domain.line.Line;

import java.util.List;
import java.util.Objects;

public class Ladder {

	private final List<Line> lines;

	public Ladder(List<Line> lines) {
		this.lines = lines;
	}

	public List<Line> getLines() {
		return lines;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Ladder ladder = (Ladder) o;
		return lines.equals(ladder.lines);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lines);
	}
}
