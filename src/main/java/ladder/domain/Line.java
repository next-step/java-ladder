package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Line {

	private final Crosses crosses;

	public static Line of(Crosses crosses) {
		return new Line(crosses);
	}

	public Line(Crosses crosses) {
		this.crosses = crosses;
	}

	public int nextIndex(int index) {
		return crosses.move(index);
	}

	public List<Cross> getCrosses() {
		return crosses.getCrosses();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Line line = (Line)o;
		return Objects.equals(crosses, line.crosses);
	}

	@Override
	public int hashCode() {
		return Objects.hash(crosses);
	}
}
