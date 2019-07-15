package ladder.model;

public class LadderNode {
	private boolean hasStep;
	private boolean isRightEdge;

	private LadderNode(boolean hasStep) {
		this.hasStep = hasStep;
		this.isRightEdge = true;
	}

	public boolean hasStep() {
		return hasStep;
	}

	public boolean isRightEdge() {
		return isRightEdge;
	}

	public LadderNode createNextNode(boolean hasStep){
		this.isRightEdge = false;
		return new LadderNode( !this.hasStep && hasStep);
	}

	public static LadderNode create(){
		return new LadderNode(false);
	}
}
