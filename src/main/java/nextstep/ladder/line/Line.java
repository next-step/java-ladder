package nextstep.ladder.line;

import nextstep.ladder.painter.RandomPointPainter;
import nextstep.ladder.point.Points;

public class Line {
	private Points points;

	public Line(int playerCount) {
		RandomPointPainter painter = new RandomPointPainter();
		this.points = painter.drawPoints(playerCount);
	}

	public Points getPoints() {
		return points;
	}
}
