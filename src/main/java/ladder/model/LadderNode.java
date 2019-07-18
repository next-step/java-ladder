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

	/**
	 * 사다리 레일을 구성하는 1개의 마디(Node) 생성
	 * @param railNumber 노드가 설치될 레일 번호
	 * @param withStep 노드의 왼쪽에 계단을 설치할지 여부
	 */
	private LadderNode(int railNumber, boolean withStep) {
		this.railNumber = railNumber;
		this.stepPosition = withStep
				? StepPosition.LEFT
				: StepPosition.NONE;
	}

	public boolean hasStep() {
		return stepPosition.equals(StepPosition.LEFT);
	}

	public boolean isInFirstRail() {
		return railNumber == START_RAIL_NUMBER;
	}

	public LadderNode createNextNode(boolean withStep) {
		LadderNode nextNode = new LadderNode(this.railNumber + 1, !this.hasStep() && withStep);
		if (nextNode.hasStep()) {
			this.stepPosition = StepPosition.RIGHT;
		}
		return nextNode;
	}

	public int nextRailNumber() {
		return railNumber + this.stepPosition.getDirectionOffset();
	}

	public static LadderNode create() {
		// 좌측 첫번째 레일(엣지)에는 스텝 설치 불가
		return new LadderNode(START_RAIL_NUMBER, false);
	}
}
