package nextstep.ladder.domain;

public enum Direction {
	LEFT(-1),
	RIGHT(1),
	NOTHING(0);

	private final int distance;

	Direction(int distance) {
		this.distance = distance;
	}

	public Position apply(Position position) {
		return position.move(this.distance);
	}
}
