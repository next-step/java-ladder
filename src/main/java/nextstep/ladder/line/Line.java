package nextstep.ladder.line;

import nextstep.ladder.painter.PaintingStrategy;
import nextstep.ladder.painter.PointPainter;
import nextstep.ladder.point.Points;

public class Line {

	private Points points;

	private Line(int playerCount, PaintingStrategy paintingStrategy) {
		PointPainter painter = new PointPainter(paintingStrategy);
		this.points = painter.drawPoints(playerCount);
	}

	public static Line ofLine(int playerCount, PaintingStrategy paintingStrategy) {
		return new Line(playerCount, paintingStrategy);
	}

	public Points getPoints() {
		return points;
	}
}
