package nextstep.ladder.domain;

public class Block {
	private final Direction direction;
	private final Position position;

	public Block(Direction direction, Position position) {
		this.direction = direction;
		this.position = position;
	}

	public Block makeNext(Direction willBeWant) {
		if (this.direction.equals(Direction.RIGHT)) {
			return new Block(Direction.LEFT, this.position.move(1));
		}

		return new Block(willBeWant, this.position.move(1));
	}

	public Direction direction() {
		return this.direction;
	}

	public Position position() {
		return this.position;
	}

	public void enter(Participant participant) {
		participant.move(this.direction);
	}
}
