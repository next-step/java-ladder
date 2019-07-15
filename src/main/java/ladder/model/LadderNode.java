package ladder.model;

public class LadderNode {
	private boolean hasStep;
	private boolean isInFirstRail;

	public LadderNode(boolean hasStep, boolean isInFirstRail) {
		this.hasStep = hasStep;
		this.isInFirstRail = isInFirstRail;
	}

	public boolean hasStep() {
		return hasStep;
	}

	public boolean isInFirstRail() {
		return isInFirstRail;
	}
}
