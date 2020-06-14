package ladder.domain;

public class LadderLine {

	private final LadderLinePoints ladderLinePoints;

	public LadderLine(int pointCount, DrawingPointStrategy drawingPointStrategy) {
		LadderLinePointPainter pointsPainter = new LadderLinePointPainter(drawingPointStrategy);
		this.ladderLinePoints = pointsPainter.drawPoints(pointCount);
	}

	public LadderLinePoints getLadderLinePoints() {
		return ladderLinePoints;
	}

	public int moveDownFrom(int position) {
		return ladderLinePoints.moveSideFrom(position);
	}
}
