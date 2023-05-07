package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ladder {

	private final List<Line> lines = new ArrayList<>();

	public static Ladder of(Points... pointsList) {
		return new Ladder(Arrays.stream(pointsList).collect(Collectors.toList()));
	}

	public Ladder(List<Points> pointsList) {
		for (Points points : pointsList) {
			this.lines.add(new Line(points));
		}
	}

	public List<Line> getLines() {
		return lines;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Ladder ladder = (Ladder)o;
		return Objects.equals(lines, ladder.lines);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lines);
	}
}
