package nextstep.ladder.domain.player;

public class Position {
	private static final int ONE_STEP = 1;
	private int position;

	private Position(int position) {
		this.position = position;
	}

	public static Position ofPosition(int position, int size) {
		validateGivenPosition(position, size);
		return new Position(position);
	}

	private static void validateGivenPosition(int givenPosition, int size) {
		if (givenPosition >= size) {
			throw new IllegalArgumentException("your given position is out of bound to current list indexes.");
		}
	}

	public int getPosition() {
		return position;
	}

	public Position updatePosition(Position position) {
		this.position = position.getPosition();
		return this;
	}

	public Position moveOneStepFurther() {
		this.position = this.position + ONE_STEP;
		return this;
	}

	public Position moveOneStepBack() {
		this.position = this.position - ONE_STEP;
		return this;
	}

	public boolean validatePosition(int size) {
		return ! (this.position >= size);
	}
}
