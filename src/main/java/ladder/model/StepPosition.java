package ladder.model;

public enum StepPosition {
	LEFT(-1),
	RIGHT(1),
	NONE(0);

	private int directionOffset;

	StepPosition(int directionOffset) {
		this.directionOffset = directionOffset;
	}

	public int getDirectionOffset() {
		return this.directionOffset;
	}
}
