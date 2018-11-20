package domain;

import com.google.common.base.Preconditions;
import domain.ladder.LadderLine;
import domain.ladder.LadderLines;
import domain.point.LadderPoints;
import domain.supplier.LadderLineSupplier;

/**
 * Created by hspark on 16/11/2018.
 */
public class Ladder {
	public static final int MIN_LADDER_HEIGHT = 1;
	public static final int MIN_LADDER_WIDTH = 0;

	private LadderPoints ladderPoints;
	private LadderLines ladderLines;

	public Ladder(int gamerCount) {
		Preconditions.checkArgument(gamerCount >= MIN_LADDER_WIDTH, "게이머 수가 너무 적습니다.");
		this.ladderPoints = new LadderPoints(gamerCount);
	}

	public void drawLadder(int height, LadderLineSupplier supplier) {
		Preconditions.checkArgument(height > MIN_LADDER_HEIGHT, "사다리 높이가 너무 낮습니다.");
		this.ladderLines = new LadderLines(height, ladderPoints.getSizeOfGamer(), supplier);
	}

	public void drawLadder(GameLevel gameLevel) {
		this.ladderLines = new LadderLines(gameLevel, ladderPoints.getSizeOfGamer());
	}

	public LadderResult getLadderGameResult() {
		return new LadderResult(ladderPoints, ladderLines);
	}

	public void moveAll() {
		int layerNumber = 0;
		while (!ladderLines.isBottomLayer(layerNumber)) {
			LadderLine ladderLine = ladderLines.getLine(layerNumber++);
			ladderPoints.moveAll(ladderLine);
		}
	}
}
