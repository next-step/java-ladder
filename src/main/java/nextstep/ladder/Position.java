package nextstep.ladder;

public class Position {
	int position;

	public Position(int position) {
		this.position = position;
	}

	public Position rightMove() {
		return new Position(++position);
	}

	public Position leftMove() {
		return new Position(--position);
	}

	public int getPosition() {
		return position;
	}

}
