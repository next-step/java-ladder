package domain;

import domain.ladder.LadderLayer;
import domain.ladder.LadderLayers;
import domain.point.Point;
import domain.point.Points;

import java.util.List;

/**
 * Created by hspark on 16/11/2018.
 */
public class LadderResult {

	public static final String ALL_GAMER = "all";
	private Points points;
	private LadderLayers ladderLayers;

	public LadderResult(Points points, LadderLayers ladderLayers) {
		this.points = points;
		this.ladderLayers = ladderLayers;
	}

	public Point getEndPointByStartPoint(Point point) {
		return points.findCurrentPointByStartPoint(point);
	}

	public List<Point> getPoints() {
		return points.getPoints();
	}

	public List<LadderLayer> getLadderLayers() {
		return ladderLayers.getLadderLayers();
	}
}
