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

	private NodeDirection getDirection(){
		if(this.hasStep){
			return NodeDirection.LEFT;
		}

		if(!isInLastRail() && nextNode.hasStep()){
			return NodeDirection.RIGHT;
		}

		return NodeDirection.STRAIGHT;
	}


	public int directionIncrement() {
		return this.getDirection().getIncrement();
	}

	public static LadderNode create(){
		return new LadderNode(false);
	}
}
