package ladder.domain.line;

import ladder.domain.point.DrawingPointStrategy;
import ladder.domain.point.PointPainter;
import ladder.domain.point.Points;

public class LadderLine {

	private final Points points;

	public LadderLine(int pointCount, DrawingPointStrategy drawingPointStrategy) {
		PointPainter pointsPainter = new PointPainter(drawingPointStrategy);
		this.points = pointsPainter.drawPoints(pointCount);
	}

	public Points getPoints() {
		return points;
	}

	public int moveDownFrom(int position) {
		return points.moveSideFrom(position);
	}
}
