package ladder.model;

public enum NodeDirection {
	LEFT(-1),
	RIGHT(1),
	STRAIGHT(0);

	int increment;

	NodeDirection(int increment){
		this.increment = increment;
	}

	public int getIncrement() {
		return this.increment;
	}
}
