package ladder;

public class LadderLine {

	private final LadderLinePoints ladderLinePoints;

	public LadderLine(int pointCount) {
		LadderLinePointPainter pointsPainter = new LadderLinePointPainter(new RandomDrawingPointStrategy());
		this.ladderLinePoints = pointsPainter.drawPoints(pointCount);
	}

	public LadderLinePoints getLadderLinePoints() {
		return ladderLinePoints;
	}

	public int moveDownFrom(int position) {
		return ladderLinePoints.moveSideFrom(position);
	}
}
