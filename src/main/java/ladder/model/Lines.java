package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import ladder.dto.LinesDto;

public class Lines {

	private final List<Line> lines;

	public Lines(List<Line> lines) {
		this.lines = Collections.unmodifiableList(lines);
	}

	public List<Line> getLines() {
		return LinesDto.of(lines).values();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lines lines1 = (Lines)o;
		return Objects.equals(lines, lines1.lines);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lines);
	}
}
