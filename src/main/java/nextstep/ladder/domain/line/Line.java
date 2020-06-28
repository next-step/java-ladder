package nextstep.ladder.domain.line;

import nextstep.ladder.domain.player.Position;
import nextstep.ladder.domain.point.Points;
import nextstep.ladder.util.painter.PaintingStrategy;
import nextstep.ladder.util.painter.PointPainter;

public class Line {

	protected Points points;

	protected Line() {
	}

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

	public Position movePosition(Position position) {
		return points.movePosition(position);
	}
}
