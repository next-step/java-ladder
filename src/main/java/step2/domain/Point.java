package step2.domain;

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
