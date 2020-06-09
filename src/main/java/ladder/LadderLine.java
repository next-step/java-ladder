package ladder;

public class LadderLine {

	private final LadderLinePoints ladderLinePoints;

	public LadderLine(int playersCount, DrawingPointsStrategy drawingPointsStrategy) {
		this.ladderLinePoints = drawingPointsStrategy.draw(playersCount);
	}

	public LadderLinePoints getLadderLinePoints() {
		return ladderLinePoints;
	}
}
