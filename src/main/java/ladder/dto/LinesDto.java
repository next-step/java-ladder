package ladder.dto;

import java.util.Collections;
import java.util.List;

import ladder.model.Line;

public class LinesDto {

	private final List<Line> lines;

	private LinesDto(List<Line> lines) {
		this.lines = Collections.unmodifiableList(lines);
	}

	public static LinesDto of(List<Line> lines) {
		return new LinesDto(lines);
	}

	public List<Line> values() {
		return lines;
	}
}
