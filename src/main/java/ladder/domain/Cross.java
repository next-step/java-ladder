package ladder.domain;

import java.util.Objects;

import ladder.type.MoveType;

public class Cross {

	private final int index;
	private final Point point;

	public Cross(int index, Point point) {
		this.index = index;
		this.point = point;
	}

	public int move() {
		return MoveType.of(this.point.direction()).move(this.index);
	}

	public boolean isCurrent() {
		return this.point.isCurrent();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Cross cross = (Cross)o;
		return index == cross.index && Objects.equals(point, cross.point);
	}

	@Override
	public int hashCode() {
		return Objects.hash(index, point);
	}
}
