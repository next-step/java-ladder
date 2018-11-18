package domain;

import domain.ladder.LadderLayer;
import domain.ladder.LadderLayers;
import domain.point.Point;
import domain.point.LadderPoints;

import java.util.List;

/**
 * Created by hspark on 16/11/2018.
 */
public class LadderResult {
	private LadderPoints ladderPoints;
	private LadderLayers ladderLayers;

	public LadderResult(LadderPoints ladderPoints, LadderLayers ladderLayers) {
		this.ladderPoints = ladderPoints;
		this.ladderLayers = ladderLayers;
	}

	public Point getEndPointByStartPoint(Point point) {
		return ladderPoints.findCurrentPointByStartPoint(point);
	}

	public List<Point> getLadderPoints() {
		return ladderPoints.getPoints();
	}

	public List<LadderLayer> getLadderLayers() {
		return ladderLayers.getLadderLayers();
	}
}
