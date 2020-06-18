package ladder.domain.point;

public class Point {

	private final boolean connectedToNextPoint;

	private Point(boolean connectedToNextPoint) {
		this.connectedToNextPoint = connectedToNextPoint;
	}

	public static Point of(boolean connectedToNextPoint) {
		return new Point(connectedToNextPoint);
	}

	public boolean isConnectedToNextPoint() {
		return connectedToNextPoint;
	}
}
