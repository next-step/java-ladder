package ladder.domain;

import java.util.List;

public class Lines {

	private final List<Line> lines;

	public Lines(List<Line> lines) {
		this.lines = lines;
	}

	public void add(Line line) {
		this.lines.add(line);
	}

	public List<Line> getLines() {
		return lines;
	}
}
