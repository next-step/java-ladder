package domain;

import domain.ladder.LadderLine;
import domain.ladder.LadderLines;
import domain.point.LadderPoints;
import domain.point.Point;

import java.util.List;

/**
 * Created by hspark on 16/11/2018.
 */
public class LadderResult {
	private LadderPoints ladderPoints;
	private LadderLines ladderLines;

	public LadderResult(LadderPoints ladderPoints, LadderLines ladderLines) {
		this.ladderPoints = ladderPoints;
		this.ladderLines = ladderLines;
	}

	public Point getEndPointByStartPoint(Point point) {
		return ladderPoints.findCurrentPointByStartPoint(point);
	}

	public List<Point> getLadderPoints() {
		return ladderPoints.getPoints();
	}

	public List<LadderLine> getLadderLines() {
		return ladderLines.getLadderLines();
	}
}
