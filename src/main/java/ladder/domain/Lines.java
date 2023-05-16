package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import ladder.strategy.PointGenerator;

public class Lines {

	private final List<Line> lines;

	public static Lines of(Line... lines) {
		return new Lines(List.of(lines));
	}

	public static Lines of(Height height, Names names, PointGenerator pointGenerator) {
		List<Line> lines = new ArrayList<>();
		for (int i = 0; i < height.getHeight(); i++) {
			lines.add(new Line(Crosses.of(names, pointGenerator)));
		}
		return new Lines(lines);
	}

	public Lines(List<Line> lines) {
		this.lines = lines;
	}

	public int finalIndex(int index) {
		for (Line line : this.lines) {
			index = line.nextIndex(index);
		}
		return index;
	}

	public List<Line> getLines() {
		return Collections.unmodifiableList(this.lines);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Lines lines1 = (Lines)o;
		return Objects.equals(lines, lines1.lines);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lines);
	}
}
