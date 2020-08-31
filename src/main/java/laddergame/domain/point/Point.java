package laddergame.domain.point;

import laddergame.domain.Coordinate;
import laddergame.domain.direction.Direction;

import java.util.Objects;

public class Point {

	private final Coordinate coordinate;
	private final Direction direction;

	public Point(Coordinate coordinate, Direction direction) {
		this.coordinate = coordinate;
		this.direction = direction;
	}

	public Coordinate goNextPoint() {
		return direction.getNextCoordinate(coordinate);
	}

	public Direction getDirection() {
		return direction;
	}

	public boolean isRightDirection() {
		return direction == Direction.RIGHT;
	}

	public boolean isLeftDirection() {
		return direction == Direction.LEFT;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Point point = (Point) o;
		return coordinate.equals(point.coordinate) &&
				direction == point.direction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(coordinate, direction);
	}
}
