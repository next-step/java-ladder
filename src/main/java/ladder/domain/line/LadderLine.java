package ladder.domain.line;

import ladder.domain.point.DrawingPointStrategy;
import ladder.domain.point.LadderLinePointPainter;
import ladder.domain.point.LadderLinePoints;

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
