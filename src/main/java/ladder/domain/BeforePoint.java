package ladder.domain;

import java.util.Objects;

public class BeforePoint {

	private final boolean beforePoint;

	public BeforePoint(boolean beforePoint) {
		this.beforePoint = beforePoint;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BeforePoint that = (BeforePoint)o;
		return beforePoint == that.beforePoint;
	}

	@Override
	public int hashCode() {
		return Objects.hash(beforePoint);
	}
}
