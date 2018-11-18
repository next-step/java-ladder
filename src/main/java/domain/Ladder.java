package domain;

import com.google.common.base.Preconditions;
import domain.ladder.LadderLayers;
import domain.point.Points;

/**
 * Created by hspark on 16/11/2018.
 */
public class Ladder {
	public static final int MIN_LADDER_HEIGHT = 1;
	public static final int MIN_LADDER_WIDTH = 0;

	private Points points;
	private LadderLayers ladderLayers;

	public Ladder(int playerCount) {
		Preconditions.checkArgument(playerCount >= MIN_LADDER_WIDTH, "너비가 너무 좁습니다.");
		this.points = new Points(playerCount);
	}

	public void drawLadder(int height, LadderLineSupplier supplier) {
		Preconditions.checkArgument(height > MIN_LADDER_HEIGHT, "사다리 높이가 너무 낮습니다.");
		this.ladderLayers = new LadderLayers(height, points.getWidth());
		ladderLayers.drawAllLadders(supplier);
	}

	public LadderResult getLadderGameResult() {
		return new LadderResult(points, ladderLayers);
	}

	public void moveAll() {
		ladderLayers.moveAll(points);
	}
}
