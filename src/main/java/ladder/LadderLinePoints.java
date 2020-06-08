package ladder;

import java.util.List;

public class LadderLinePoints {

	private final List<LadderLinePoint> ladderLinePoints;

	public LadderLinePoints(List<LadderLinePoint> ladderLinePoints) {
		this.ladderLinePoints = ladderLinePoints;
	}

	public int size() {
		return ladderLinePoints.size();
	}
}
