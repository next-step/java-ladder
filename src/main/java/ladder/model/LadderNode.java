package ladder.model;

public class LadderNode {
	private boolean hasStep;
	private boolean isInFirstRail;

	private LadderNode(boolean hasStep, boolean isInFirstRail) {
		this.hasStep = hasStep;
		this.isInFirstRail = isInFirstRail;
	}

	public boolean hasStep() {
		return hasStep;
	}

	public boolean isInFirstRail() {
		return isInFirstRail;
	}

	public LadderNode createNextNode(boolean hasStep){
		return new LadderNode( hasStep,false);
	}

	public static LadderNode create(){
		return new LadderNode(false, true);
	}
}
