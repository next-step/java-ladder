package domain;

import com.google.common.base.Preconditions;
import domain.ladder.LadderLayer;
import domain.ladder.LadderLayers;
import domain.point.LadderPoints;

/**
 * Created by hspark on 16/11/2018.
 */
public class Ladder {
	public static final int MIN_LADDER_HEIGHT = 1;
	public static final int MIN_LADDER_WIDTH = 0;

	private LadderPoints ladderPoints;
	private LadderLayers ladderLayers;

	public Ladder(int gamerCount) {
		Preconditions.checkArgument(gamerCount >= MIN_LADDER_WIDTH, "게이머 수가 너무 적습니다.");
		this.ladderPoints = new LadderPoints(gamerCount);
	}

	public void drawLadder(int height, LadderLineSupplier supplier) {
		Preconditions.checkArgument(height > MIN_LADDER_HEIGHT, "사다리 높이가 너무 낮습니다.");
		this.ladderLayers = new LadderLayers(height, ladderPoints.getWidth());
		ladderLayers.drawAllLadders(supplier);
	}

	public LadderResult getLadderGameResult() {
		return new LadderResult(ladderPoints, ladderLayers);
	}

	public void moveAll() {
		int layerNumber = 0;
		while (!ladderLayers.isBottomLayer(layerNumber)) {
			LadderLayer ladderLayer = ladderLayers.getLayer(layerNumber++);
			ladderPoints.moveAll(ladderLayer);
		}
	}
}
