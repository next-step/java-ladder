package ladder.model;

public class LadderNode {
	private boolean hasStep;
	private LadderNode nextNode;

	private LadderNode(boolean hasStep) {
		this.hasStep = hasStep;
	}

	public boolean hasStep() {
		return hasStep;
	}

	public boolean isInLastRail() {
		return nextNode == null;
	}

	public LadderNode createNextNode(boolean hasStep){
		this.nextNode = new LadderNode( !this.hasStep && hasStep);
		return nextNode;
	}

	public static LadderNode create(){
		return new LadderNode(false);
	}
}
