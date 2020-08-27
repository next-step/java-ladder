package step2.domain;

import step2.exception.LadderGameException;

import java.util.Objects;

public class Coordinate {

	private static final Coordinate COORDINATE_ONE = new Coordinate(1);

	private static final String PLEASE_INPUT_OVER_OR_EQUAL_MIN_COORDINATE = "%d 보다 작은 수를 좌표 값으로 설정할 수 없습니다.";
	private static final int MIN_COORDINATE = 0;

	private final int coordinate;

	public Coordinate(int coordinate) {
		if(coordinate < MIN_COORDINATE) {
			throw new LadderGameException(String.format(PLEASE_INPUT_OVER_OR_EQUAL_MIN_COORDINATE, MIN_COORDINATE));
		}
		this.coordinate = coordinate;
	}

	public int getCoordinate() {
		return coordinate;
	}

	public Coordinate decreaseCoordinate() {
		return new Coordinate(this.coordinate - COORDINATE_ONE.coordinate);
	}

	public Coordinate increaseCoordinate() {
		return new Coordinate(this.coordinate + COORDINATE_ONE.coordinate);
	}

	public Coordinate keepCoordinate() {
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Coordinate that = (Coordinate) o;
		return coordinate == that.coordinate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(coordinate);
	}
}
