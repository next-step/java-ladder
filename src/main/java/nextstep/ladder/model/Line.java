package nextstep.ladder.model;

import java.util.Objects;

public class Line {
	private final Boolean hasLine;

	public Line(final boolean hasLine) {
		this.hasLine = hasLine;
	}

	public static Line create(final Line prevLine) {
		if (prevLine == null || !prevLine.hasLine) {
			return new Line(true);
		}
		return new Line(false);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final Line line = (Line)o;
		return Objects.equals(hasLine, line.hasLine);
	}

	@Override
	public int hashCode() {
		return Objects.hash(hasLine);
	}
}
