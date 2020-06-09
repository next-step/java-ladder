package ladder;

public class LadderLine {

	private final LadderLinePoints ladderLinePoints;

	public LadderLine(int playersCount, DrawingPointStrategy drawingPointStrategy) {
		LadderLinePointPainter pointsPainter = new LadderLinePointPainter(drawingPointStrategy);
		this.ladderLinePoints = pointsPainter.drawPoints(playersCount);
	}

	public LadderLinePoints getLadderLinePoints() {
		return ladderLinePoints;
	}
}
