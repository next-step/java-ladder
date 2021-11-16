package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
	private final boolean hasLine;

	private Point(boolean hasLine) {
		this.hasLine = hasLine;
	}

	public static Point create(boolean hasLine) {
		return new Point(hasLine);
	}

	public static Point createHasNotLine() {
		return new Point(false);
	}

	public boolean hasLine() {
		return hasLine;
	}

	public Point calculatePrev(Point prev) {
		return create(!prev.hasLine && this.hasLine);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Point point = (Point)obj;

		return Objects.equals(hasLine, point.hasLine);
	}

	@Override
	public int hashCode() {
		return Objects.hash(hasLine);
	}

	@Override
	public String toString() {
		return "Point{" +
			"hasLine=" + hasLine +
			'}';
	}
}
