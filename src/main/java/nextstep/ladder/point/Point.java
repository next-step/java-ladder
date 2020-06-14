package nextstep.ladder.point;

public class Point {
	private boolean isConnectedToNextPoint;

	private Point(boolean isConnectedToNextPoint) {
		this.isConnectedToNextPoint = isConnectedToNextPoint;
	}

	public static Point ofPoint(boolean isConnectedToNextPoint) {
		return new Point(isConnectedToNextPoint);
	}
}
