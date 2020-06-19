package ladder.domain.line;

import ladder.domain.point.PointPainter;
import ladder.domain.point.Points;

public class LadderLine {

	private final Points points;

	public LadderLine(int pointCount, PointPainter pointPainter) {
		this.points = pointPainter.drawPoints(pointCount);
	}

	public Points getPoints() {
		return points;
	}

	public int moveDownFrom(int position) {
		return points.moveSideFrom(position);
	}
}
