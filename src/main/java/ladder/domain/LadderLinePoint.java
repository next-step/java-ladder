package ladder.domain;

public class LadderLinePoint {

	private final boolean connectedToNextPoint;

	private LadderLinePoint(boolean connectedToNextPoint) {
		this.connectedToNextPoint = connectedToNextPoint;
	}

	public static LadderLinePoint of(boolean connectedToNextPoint) {
		return new LadderLinePoint(connectedToNextPoint);
	}

	public boolean isConnectedToNextPoint() {
		return connectedToNextPoint;
	}
}
