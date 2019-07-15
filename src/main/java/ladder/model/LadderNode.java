package ladder.model;

public class LadderNode {
	private LadderNode nextNode;
	private StepPosition stepPosition;

	private LadderNode(boolean hasStep) {
		this.stepPosition = hasStep
			? StepPosition.LEFT
			: StepPosition.NONE;
	}

	public boolean hasStep() {
		return stepPosition.equals(StepPosition.LEFT);
	}

	public boolean isInLastRail() {
		return nextNode == null;
	}

	public LadderNode createNextNode(boolean hasStep){
		this.nextNode = new LadderNode( !this.hasStep() && hasStep);
		if(nextNode.hasStep()){
			this.stepPosition = StepPosition.RIGHT;
		}
		return nextNode;
	}

	public int nextRailNumber() {
		return this.stepPosition.getIncrement();
	}

	public static LadderNode create(){
		return new LadderNode(false);
	}
}
