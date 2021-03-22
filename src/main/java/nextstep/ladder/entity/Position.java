package nextstep.ladder.entity;

import java.util.Objects;

public class Position {
	private final int position;

	public Position(Position position) {
		this(position.position);
	}

	public Position(int position) {
		this.position = position;
	}

	Position move(Root root, int rootIndex) {
		return PositionMoveMatch.getMatchPosition(root, rootIndex, this);
	}

	public Position moveRight() {
		return new Position(position + 1);
	}

	public Position moveLeft() {
		return new Position(position - 1);
	}

	public int getPosition() {
		return position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Position position1 = (Position) o;
		return position == position1.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}

	@Override
	public String toString() {
		return String.valueOf(this.position);
	}
}
