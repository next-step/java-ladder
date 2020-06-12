package ladder;

public class LadderLine {

	private final LadderLinePoints ladderLinePoints;

	public LadderLine(int playersCount) {
		LadderLinePointPainter pointsPainter = new LadderLinePointPainter(new RandomDrawingPointStrategy());
		this.ladderLinePoints = pointsPainter.drawPoints(playersCount);
	}

	public LadderLinePoints getLadderLinePoints() {
		return ladderLinePoints;
	}
}
