package step2.domain;

public class Point {

	private final int coordinate;
	private final Direction direction;

	public Point(int coordinate, Direction direction) {
		this.coordinate = coordinate;
		this.direction = direction;
	}

	public Integer goNextPoint() {
		return direction.getNextCoordinate(coordinate);
	}
}
