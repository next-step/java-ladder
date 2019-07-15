package ladder.model;

public enum StepPosition {
	LEFT(-1),
	RIGHT(1),
	NONE(0);

	int increment;

	StepPosition(int increment) {
		this.increment = increment;
	}

	public int getIncrement() {
		return this.increment;
	}
}
