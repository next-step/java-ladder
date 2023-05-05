package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

	private final Lines lines;
	private final Height height;

	public Ladder(Names names, int height) {
		this.lines = new Lines(new ArrayList<>());
		this.height = new Height(height);
		IntStream.range(0, height).forEach(i -> this.lines.add(new Line(names.countOfPerson())));
	}

	public List<Line> getLines() {
		return this.lines.getLines();
	}
}
