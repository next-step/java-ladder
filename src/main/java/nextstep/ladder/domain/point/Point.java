package nextstep.ladder.domain.point;

public class Point {
	private boolean isConnectedToNextPoint;

	private Point(boolean isConnectedToNextPoint) {
		this.isConnectedToNextPoint = isConnectedToNextPoint;
	}

	public static Point ofPoint(boolean isConnectedToNextPoint) {
		return new Point(isConnectedToNextPoint);
	}

	public void validateNotConnectedIfLastPoint() {
		if (isConnectedToNextPoint) {
			throw new IllegalArgumentException("last point should not be connected to the next point.");
		}
	}

	public boolean isConnectedToNextPoint() {
		return isConnectedToNextPoint;
	}
}
