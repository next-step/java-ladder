package ladder.model;

public class LadderNode {

	private static final int START_RAIL_NUMBER = 0;

	/**
	 * 현재 노드가 설치된 레일 번호
	 */
	private int railNumber;

	/**
	 * 현재 노드(레일)기준 계단 위치
	 */
	private StepPosition stepPosition;

	private LadderNode(int railNumber, boolean hasLeftStep) {
		this.railNumber = railNumber;
		this.stepPosition = hasLeftStep
				? StepPosition.LEFT
				: StepPosition.NONE;
	}

	public boolean hasLeftStep() {
		return stepPosition.equals(StepPosition.LEFT);
	}

	public boolean isInFirstRail() {
		return railNumber == START_RAIL_NUMBER;
	}

	public LadderNode createNextNode(boolean hasLeftStep) {
		LadderNode nextNode = new LadderNode(this.railNumber + 1, !this.hasLeftStep() && hasLeftStep);
		if (nextNode.hasLeftStep()) {
			this.stepPosition = StepPosition.RIGHT;
		}
		return nextNode;
	}

	public int nextRailNumber() {
		return railNumber + this.stepPosition.getIncrement();
	}

	public static LadderNode create() {
		return new LadderNode(START_RAIL_NUMBER, false);
	}
}
